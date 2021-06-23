import React from 'react';
import ProgressBar from '../../../common/ProgressBar';
import { Text as S } from '../../../styles/CommonStyles';
import { MilestoneDataProps } from '../../../../utils/types/sideBarType';

const MilestoneContent = ({
  checkedMilestone,
}: MilestoneDataProps): JSX.Element => {
  return (
    <>
      {checkedMilestone?.length !== 0 && <ProgressBar />}
      <S.TextSmall>
        {checkedMilestone && checkedMilestone[0]?.title}
      </S.TextSmall>
    </>
  );
};

export default MilestoneContent;
