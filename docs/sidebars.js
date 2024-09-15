// @ts-check

/**
 *
 * サイドバー
 *
 * - マニュアルで管理
 */

/** @type {import('@docusaurus/plugin-content-docs').SidebarsConfig} */
const sidebars = {
  docs: [
    'intro',
    {
      type: 'category',
      label: 'アーキテクチャ',
      items: ['architecture/create-a-document'],
    },
  ],
};

module.exports = sidebars;
