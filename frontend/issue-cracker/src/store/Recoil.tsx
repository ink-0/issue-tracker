import { atom, selector } from 'recoil';

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

//get: 상태값 사용
//set: 새로운 값으로 상태값 변경
export const issueForm = selector({
  key: 'issueForm',
  get: async () => {
    const response = await fetch('http://localhost:8080/api/web/issues/form');
    const data = await response.json();
    return data;
  },
});

// export const DecodedToken = selector({
//   key: 'setToken',
//   get: ({get}) => {
//     const token = get(token)
//     const decoded = jwtDecoded(token)
//     return decoded
//   }
// })
