import React from 'react';
import styled from 'styled-components';
import MilestoneTableHeader from './MilestoneTableHeader';
import MilestoneCell from './MilestoneCell';

const MilestoneTable = (): JSX.Element => {
  return (
    <IssueTableContainer>
      <React.Suspense fallback={null}>
        <MilestoneTableHeader />
      </React.Suspense>
      <React.Suspense fallback={null}>
        <MilestoneCell />
      </React.Suspense>
    </IssueTableContainer>
  );
};

export default MilestoneTable;

const IssueTableContainer = styled.div``;
