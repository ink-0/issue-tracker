import React from 'react';
import ProgressBar from '../../../common/ProgressBar';
import { Text as S } from '../../../styles/CommonStyles';
import { MilestoneDataProps } from '../../../../utils/types/sideBarType';

const MilestoneContent = ({
  milestoneList,
}: MilestoneDataProps): JSX.Element => {
  return (
    <>
      {milestoneList && <ProgressBar />}
      <S.TextSmall>{milestoneList[0]?.title}</S.TextSmall>
    </>
  );
};

export default MilestoneContent;
