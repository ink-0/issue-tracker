import { atom, selector } from 'recoil';

import {
  AssigneeProps,
  LabelProps,
  MilestoneProps,
} from '../utils/types/sideBarType';
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

export const issueForm = selector({
  key: 'issueForm',
  get: async () => {
    const response = await fetch('http://localhost:8080/api/web/issues/form');
    const data = await response.json();
    return data;
  },
});

export const selectedAssignee = atom({
  key: 'selectedAssignee',
  default: [],
});

export const selectedLabel = atom({
  key: 'selectedLabel',
  default: [],
});

export const selectedMilestone = atom({
  key: 'selectedMilestone',
  default: [],
});

export const dropCheckState = atom({
  key: 'dropCheckState',
  default: {
    assignee: [] as AssigneeProps[],
    label: [] as LabelProps[],
    milestone: [] as MilestoneProps[],
  },
});
