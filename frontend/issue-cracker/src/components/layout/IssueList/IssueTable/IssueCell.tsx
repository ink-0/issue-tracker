import React from 'react';
import {
  Issue as S,
  Text as T,
  ProfileImg as P,
} from '../../../styles/CommonStyles';
import CheckBoxes from '../../../common/CheckBoxes';
import IssueOpenIcon from '../../../styles/svg/IssueOpenIcon';
import styled from 'styled-components';
import LabelSmallGroup from '../../../common/group/LabelSmallGroup';
import { Link } from 'react-router-dom';
import { decodedToken } from '../../../../store/Recoil';
import { useRecoilValue } from 'recoil';
import { IssueDataProps } from '../../../../utils/types/IssueDataType';
import IssueDetail from '../../IssueDetail';
import { v4 as uuidv4 } from 'uuid';

const IssueCell = ({ issues }: { issues: IssueDataProps[] }): JSX.Element => {
  const decoded = decodedToken && useRecoilValue(decodedToken);
  const profileURL = decoded && decoded.profileImageUrl;
  console.log('이슈셀데이터', issues);

  const getIssue = (list: IssueDataProps[], str: string): IssueDataProps[] =>
    list.filter((el) => el.status === str);

  const getElapsedTime = (date: string): string => {
    const createdTime = new Date(2021, 5, 24, 4, 13, 0);
    const current = new Date();
    const gapMin = Math.floor((+current - +createdTime) / 1000 / 60);

    if (gapMin < 1) return '방금 전';

    if (gapMin < 60) return `${gapMin}분 전`;

    const gapHour = Math.floor(gapMin / 60);
    if (gapHour < 24) return `${gapHour}시간 전`;

    const gapDay = Math.floor(gapHour / 24);
    if (gapDay < 30) return `${gapDay}일 전`;

    const gapMonth = Math.floor(gapDay / 12);
    if (gapMonth < 12) return `${gapMonth}달 전`;

    return '몇 년 전';
  };

  // console.log(getElapsedTime(issues[0].createdDateTime));
  const openIssue = getIssue(issues, 'OPEN');
  const closedIssue = getIssue(issues, 'CLOSED');

  return (
    <>
      {openIssue.map((issue) => (
        <S.IssueCell key={uuidv4()}>
          <>
            <LeftBox>
              <CheckBoxes />
              <IssueCellContent>
                <Link
                  to={{
                    pathname: '/main/issue-detail/1',
                    state: {
                      issueNumber: `${issue.issueId}`,
                      title: `${issue.title}`,
                      content: `${issue.content}`,
                      isOpen: `${issue.content}`,
                      writer: `${issue.writer.id}`,
                      date: `${issue.createdDateTime}`,
                    },
                  }}
                >
                  <IssueUpper>
                    <IssueOpenIcon
                      color="#3f51b5"
                      style={{ width: 24, height: 24 }}
                    />
                    <IssueTitle>{issue.title}</IssueTitle>
                    {issue.labels.map((label) => {
                      <LabelSmallGroup
                        color={label.textColorHexa}
                        backgroundColor={label.backgroundColorHexa}
                        label={label.title}
                      ></LabelSmallGroup>;
                    })}
                  </IssueUpper>
                </Link>
                <T.TextSmall color="#6E7191">
                  <IssueLower>
                    <IssueID>#{issue.issueId}</IssueID>
                    <IssueContent>
                      이 이슈가 {getElapsedTime(issue.createdDateTime)},
                      ink-0님에 의해 작성되었습니다.
                    </IssueContent>
                    <IssueMileStone>{issue.milestoneInfo.title}</IssueMileStone>
                  </IssueLower>
                </T.TextSmall>
              </IssueCellContent>
            </LeftBox>
            <RightBox>
              {profileURL && <P.ProfileImgSmall src={profileURL} />}
            </RightBox>
          </>
        </S.IssueCell>
      ))}
    </>
  );
};

export default IssueCell;

const LeftBox = styled.div`
  display: flex;
`;
const RightBox = styled.div`
  display: flex;
  align-items: center;
  margin-right: 40px;
`;
const IssueCellContent = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: space-evenly;

  a {
    text-decoration: none;
    color: inherit;
  }
`;
const IssueUpper = styled.div`
  display: flex;
  align-items: center;
`;
const IssueLower = styled.div`
  display: flex;
`;
const IssueID = styled.div``;
const IssueContent = styled.div`
  margin: 0 16px;
`;
const IssueMileStone = styled.div``;
const IssueTitle = styled.div`
  font-weight: 600;
  margin: 0 9px;
`;
