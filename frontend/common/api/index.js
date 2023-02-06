import axios from "axios";

function apiInstance() {
  const instance = axios.create({
    baseURL: 'http://i8c207.p.ssafy.io:8080',
  });
  return instance;
}

export { apiInstance,};
