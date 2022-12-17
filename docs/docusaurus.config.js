// @ts-check
// Note: type annotations allow type checking and IDEs autocompletion

const lightCodeTheme = require('prism-react-renderer/themes/github');
const darkCodeTheme = require('prism-react-renderer/themes/dracula');

/** @type {import('@docusaurus/types').Config} */
const config = {
  title: '空き家でGo',
  tagline: '空き家情報をまずは共有、そして解決へ',
  url: 'https://sunabak0.github.io/',
  //
  // ドキュメントのルート
  //
  // 開発時も以下のURLになる
  // http://localhost:3000/akiyadego-kotlin/
  //
  baseUrl: '/akiyadego-kotlin/',
  onBrokenLinks: 'throw',
  onBrokenMarkdownLinks: 'warn',
  favicon: 'img/favicon.ico',

  // GitHub pages deployment config.
  // If you aren't using GitHub pages, you don't need these.
  organizationName: 'sunabak0', // Usually your GitHub org/user name.
  projectName: 'akiyadego-kotlin', // Usually your repo name.

  // Even if you don't use internalization, you can use this field to set useful
  // metadata like html lang. For example, if your site is Chinese, you may want
  // to replace "en" with "zh-Hans".
  i18n: {
    defaultLocale: 'ja',
    locales: ['ja'],
  },

  presets: [
    [
      'classic',
      /** @type {import('@docusaurus/preset-classic').Options} */
      ({
        docs: {
          sidebarPath: require.resolve('./sidebars.js'),
        },
        blog: {
          showReadingTime: true,
        },
        theme: {
          customCss: require.resolve('./src/css/custom.css'),
        },
      }),
    ],
  ],

  themeConfig:
    /** @type {import('@docusaurus/preset-classic').ThemeConfig} */
    ({
      navbar: {
        title: '空き家でGo',
        logo: {
          alt: '空き家でGoのロゴ画像',
          src: 'https://3.bp.blogspot.com/-hv0I1T3MuaM/Udy6iRcorII/AAAAAAAAWH4/7jIZoHSoUnE/s800/building_boroya.png',
        },
        items: [
          {
            type: 'doc',
            docId: 'intro',
            position: 'left',
            label: 'ドキュメント',
          },
          {to: '/blog', label: 'Blog', position: 'left'},
          {
            href: 'https://github.com/sunabak0/akiyadego-kotlin',
            label: 'GitHub',
            position: 'right',
          },
        ],
      },
      footer: {
        style: 'dark',
        links: [
          {
            title: 'Docs',
            items: [
              {
                label: 'Tutorial',
                to: '/docs/intro',
              },
            ],
          },
          {
            title: 'GitHub',
            items: [
              {
                label: 'sunabak0/akiyadego-kotlin',
                href: 'https://github.com/sunabak0/akiyadego-kotlin',
              },
              {
                label: 'sunabak0/akiyadego-openapi',
                href: 'https://github.com/sunabak0/akiyadego-openapi',
              },
            ],
          },
        ],
        copyright: `Copyright © ${new Date().getFullYear()} 空き家でGo Project`,
      },
      prism: {
        theme: lightCodeTheme,
        darkTheme: darkCodeTheme,
      },
    }),
};

module.exports = config;
