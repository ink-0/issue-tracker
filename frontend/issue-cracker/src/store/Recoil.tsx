import { atom, selector } from 'recoil';
import {
  AssigneeProps,
  LabelProps,
  MilestoneProps,
} from '../utils/types/sideBarType';
import { URL as U } from '../utils/const';

// Login

export const addState = atom({
  key: 'addState',
  default: false,
});

export const token = atom({
  key: 'token',
  default: null,
});

export const decodedToken = atom({
  key: 'decodedToken',
  default: {
    name: '',
    profileImageUrl: '',
  },
});

//SideBar
export const issueForm = selector({
  key: 'issueForm',
  get: async () => {
    const response = await fetch(U.FORM);
    const data = await response.json();
    return data;
  },
});

export const dropAssigneeState = atom({
  key: 'dropAssigneeState',
  default: false,
});
export const dropLabelState = atom({
  key: 'dropLabelState',
  default: false,
});
export const dropMilestoneState = atom({
  key: 'dropMilestoneState',
  default: false,
});

export const dropCheckState = atom({
  key: 'dropCheckState',
  default: {
    assignee: [] as AssigneeProps[],
    label: [] as LabelProps[],
    milestone: [] as MilestoneProps[],
  },
});

//IssueList

export const issueListData = selector({
  key: 'issueListData',
  get: async () => {
    const response = await fetch(U.ISSUES);
    const data = await response.json();
    return data;
  },
});

// MilestoneList

export const milestoneListData = selector({
  key: 'milestoneListData',
  get: async () => {
    const response = await fetch(U.MILESTONE);
    const data = await response.json();
    return data;
  },
});

// //IssueAdd
interface IssueAddStateProps {
  title: string;
  comment: string;
}

export const issueAddState = atom<IssueAddStateProps>({
  key: 'issueAddState',
  default: {
    title: '',
    comment: '',
  },
});

export const issueAddData = selector({
  key: 'issueAddData',
  //iisse
  get: ({ get }) => {
    const inputData = get(issueAddState);
    const dropData = get(dropCheckState);

    const assigneesIdList = dropData.assignee.map((ele) => ele.id);
    const labelsIdList = dropData.label.map((ele) => ele.id);
    const milestonesIdList = dropData.milestone.map((ele) => ele.id);
    return {
      title: inputData.title,
      comment: inputData.comment,
      assigneesId: assigneesIdList,
      labelsId: labelsIdList,
      milestoneId: milestonesIdList,
    };
    return inputData;
  },
});

// interface issuePostProps {
//   title: string;
//   comment: string;
//   assigneesId: string[];
//   labelsId: number[];
//   milestoneId: number;
// }

// export const issuePost = atom<issuePostProps>({
//   key: 'issuePost',
//   default: {
//     title: '',
//     comment: '',
//     assigneesId: [],
//     labelsId: [],
//     milestoneId: 0,
//   },
// });
//
