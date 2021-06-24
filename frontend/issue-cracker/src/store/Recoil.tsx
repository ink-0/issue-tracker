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
