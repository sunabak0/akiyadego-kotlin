.PHONY: setup
setup: ## 開発環境のセットアップ
	@bash scripts/setup.sh

.PHONY: fmt
fmt: ## format
	./gradlew detekt --auto-correct

.PHONY: lint.kt
lint.kt: ## Kotlin の lint
	./gradlew detekt

.PHONY: lint.commit-msgs
lint.commit-msgs: ## git commit messages を lint
	@bash scripts/lint-git-commit-messages.sh

.PHONY: lint.pr
lint.pr: ## GitHub の PR を lint
	@bash scripts/lint-current-branch-pull-request.sh

.PHONY: lint.gh-action
lint.gh-action: ## GitHub Action を lint
	docker run --rm --mount type=bind,source=${PWD},target=/repo --workdir /repo rhysd/actionlint:latest -color

.PHONY: lint.yaml
lint.yaml: ## YAML ファイルを lint
	docker run --rm -it --mount type=bind,source=${PWD}/,target=/code/ pipelinecomponents/yamllint yamllint .

.PHONY: lint.shell
lint.shell: ## Shell script を lint
	docker run --rm --mount type=bind,source=${PWD}/,target=/mnt koalaman/shellcheck:stable **/*.sh

################################################################################
# git 関連
################################################################################
.PHONY: git.check-for-submodule-updates
git.check-for-submodule-updates: ## submodule の更新があるかどうかチェックする
	@bash scripts/check-for-submodule-updates

.PHONY: git.update-submodule
git.update-submodule: ## git submodule を最新版にアップデート
	git submodule update --init --recursive --remote

################################################################################
# Utility-Command help
################################################################################
.DEFAULT_GOAL := help

################################################################################
# マクロ
################################################################################
# Makefileの中身を抽出してhelpとして1行で出す
# $(1): Makefile名
define help
  grep -E '^[\.a-zA-Z0-9_-]+:.*?## .*$$' $(1) \
  | grep --invert-match "## non-help" \
  | awk 'BEGIN {FS = ":.*?## "}; {printf "\033[36m%-20s\033[0m %s\n", $$1, $$2}'
endef

################################################################################
# タスク
################################################################################
.PHONY: help
help: ## Make タスク一覧
	@echo '######################################################################'
	@echo '# Makeタスク一覧'
	@echo '# $$ make XXX'
	@echo '# or'
	@echo '# $$ make XXX --dry-run'
	@echo '######################################################################'
	@echo $(MAKEFILE_LIST) \
	| tr ' ' '\n' \
	| xargs -I {included-makefile} $(call help,{included-makefile})
