import React from 'react';
import clsx from 'clsx';
import styles from './styles.module.css';

const FeatureList = [
  {
    title: '空き家',
    imgSrc: 'https://2.bp.blogspot.com/-NET9o7E-ncA/VYJraiNXGsI/AAAAAAAAuc0/2JYbaD8ny9E/s800/building_akiya.png',
    imgAlt: '空き家の画像',
    description: (
      <>
        1年以上誰も住んでいない状態<br />
        1年以上何も使われていない状態
      </>
    ),
  },
  {
    title: '空き家',
    imgSrc: 'https://2.bp.blogspot.com/-NET9o7E-ncA/VYJraiNXGsI/AAAAAAAAuc0/2JYbaD8ny9E/s800/building_akiya.png',
    imgAlt: '空き家の画像',
    description: (
      <>
        1年以上誰も住んでいない状態<br />
        1年以上何も使われていない状態
      </>
    ),
  },
  {
    title: '空き家',
    imgSrc: 'https://2.bp.blogspot.com/-NET9o7E-ncA/VYJraiNXGsI/AAAAAAAAuc0/2JYbaD8ny9E/s800/building_akiya.png',
    imgAlt: '空き家の画像',
    description: (
      <>
        1年以上誰も住んでいない状態<br />
        1年以上何も使われていない状態
      </>
    ),
  },
];

function Feature({imgSrc, imgAlt, title, description}) {
  return (
    <div className={clsx('col col--4')}>
      <div className="text--center">
        <img className={styles.featureImg} src={imgSrc} alt={imgAlt} />
      </div>
      <div className="text--center padding-horiz--md">
        <h3>{title}</h3>
        <p>{description}</p>
      </div>
    </div>
  );
}

export default function HomepageFeatures() {
  return (
    <section className={styles.features}>
      <div className="container">
        <div className="row">
          {FeatureList.map((props, idx) => (
            <Feature key={idx} {...props} />
          ))}
        </div>
      </div>
    </section>
  );
}
