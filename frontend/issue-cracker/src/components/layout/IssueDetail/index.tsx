import React from 'react';
import { useLocation } from 'react-router-dom';
import styled from 'styled-components';
import IssueDetailTitle from './IssueDetailTitle';
import { Line as S } from '../../styles/CommonStyles';
import IssueDetailBox from './IssueDetailBox';
import { AssigneeProps } from '../../../utils/types/sideBarType';

interface LocationStateProps {
  issueId: number;
  title: string;
  content: string;
  isOpen: boolean;
  writer: string | null;
  elapsedTime: string;
  assignees: AssigneeProps[];
}

const IssueDetail = (): JSX.Element => {
  const { state } = useLocation<LocationStateProps>();
  const { title, isOpen, elapsedTime, assignees } = state;
  console.log(assignees);
  return (
    <>
      <IssueDetailStyle>
        <IssueDetailTitle {...{ title, isOpen, elapsedTime }} />
        <S.TableLine />
        <IssueDetailBox />
      </IssueDetailStyle>
    </>
  );
};

export default IssueDetail;

const IssueDetailStyle = styled.div``;
