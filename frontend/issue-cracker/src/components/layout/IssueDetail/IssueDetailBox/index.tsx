import React from 'react';
import styled from 'styled-components';
import IssueDetailInput from './IssueDetailInput';
import IssueDetailSidebar from './IssueDetailSidebar';
import { IssueDataProps } from '../../../../utils/types/IssueDataType';

const IssueDetailBox = ({ state }: { state: IssueDataProps }): JSX.Element => {
  return (
    <IssueDetailBoxStyle>
      <IssueDetailInput {...{ state }} />
      <IssueDetailSidebar {...{ state }} />
    </IssueDetailBoxStyle>
  );
};

export default IssueDetailBox;

const IssueDetailBoxStyle = styled.div`
  display: flex;
`;
