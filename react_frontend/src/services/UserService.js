import axios from 'axios'

const USERS_REST_API_URL = 'http://localhost:8081/auth/rest/hello/principal';

class UserService {

    getUserName(){
        return axios.get(USERS_REST_API_URL);
    }
}

export default new UserService();