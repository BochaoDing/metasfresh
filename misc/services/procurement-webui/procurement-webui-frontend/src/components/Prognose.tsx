import React, { ReactElement } from 'react';
import { translate } from '../utils/translate';
import classnames from 'classnames';
interface Props {
  nextWeek: string;
  trend?: string;
}
const Prognose: React.FunctionComponent<Props> = ({ nextWeek, trend }: Props): ReactElement => {
  let prognoseHeader = translate('WeeklyDetailedReportingView.toolbar.caption');
  prognoseHeader = prognoseHeader.replace(`{0}`, nextWeek);
  return (
    <div>
      <div className="container prognose-box pl-3 pr-3">
        <div className="columns is-mobile">
          <div className="column is-12 has-text-centered pb-0">{prognoseHeader}</div>
        </div>
        <div className="columns is-mobile has-text-centered pb-3">
          <div
            className={classnames('column is-mobile-4', {
              'up-active': trend === 'trend-up',
              up: trend !== 'trend-up',
            })}
          >
            <i className="fas fa-arrow-up fa-lg"></i>
          </div>
          <div
            className={classnames('column is-mobile-4', {
              'down-active': trend === 'trend-down',
              down: trend !== 'trend-down',
            })}
          >
            <i className="fas fa-arrow-down fa-lg"></i>
          </div>
          <div
            className={classnames('column is-mobile-4', {
              'right-active': trend === 'trend-even',
              right: trend !== 'trend-even',
            })}
          >
            <i className="fas fa-arrow-right fa-lg"></i>
          </div>
          <div
            className={classnames('column is-mobile-4', {
              'disabled-active': trend === 'trend-zero',
              disabled: trend !== 'trend-zero',
            })}
          >
            <i className="fas fa-times fa-lg"></i>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Prognose;
