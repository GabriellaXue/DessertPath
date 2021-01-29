import React from 'react';
import UserService from '../services/UserService';

class UserComponent extends React.Component {

    constructor(props){
        super(props)
        this.state = {
            usernames:[]
        }
    }

    componentDidMount(){
        UserService.getUserName().then((response) => {
            this.setState({ usernames: response.data})
        });
    }

    render (){
        return (
            <div>
                <h1 className = "text-center"> Users List</h1>
                <table className = "table table-striped">
                    <thead>
                    <tr>
                        <td> User Name</td>
                    </tr>

                    </thead>
                    <tbody>
                    {
                        this.state.usernames.map(
                            user =>
                                <tr key = {user.name}>
                                    <td> {user.name} </td>
                                </tr>
                        )
                    }

                    </tbody>
                </table>

            </div>

        )
    }
}

export default UserComponent