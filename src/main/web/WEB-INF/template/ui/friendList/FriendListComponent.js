import React from 'react';
import {render} from 'react-dom';
const ReactDOM = require('react-dom');

class FriendListComponent extends React.Component {

    constructor(props) {
        super(props);
        let friendLabel = { // just to define format object
            id : "",
            firstName : "",
            lastName : "",
            isFacebookAccount : false,
            menuItems : [
                {itemName : "", itemHref : ""}
            ]
        };
        this.state = {
            friends : [],
            popupVisibility: {visibility : 'hidden', top : '0px', right: '0px', height: '128px', width: '192px'},
            selectedFriend: {}
        };
        this.togglePopupVisibility= this.togglePopupVisibility.bind(this);
    }

    initFriends() {
        var tab = [];

        for(let i=0; i<10; i++) {
             let friendLabel = {
                id : "Abdou.Diab"+i,
                firstName: "abdessamed",
                lastName: "diab",
                isFacebookAccount: true,
                menuItems: [
                    {itemName : "create new Model", itemValue : "https:cirtaflow1"},
                    {itemName : "assign to", itemValue : "https:cirtaflow2"},
                    {itemName : "share with ...", itemValue : "https:cirtaflow3"}
                ]
            };
            tab.push(friendLabel)
        }
        this.setState({friends : tab});
    }

    togglePopupVisibility(id) {
        console.log("toggle popup visibility.");
        let friendDivElement = ReactDOM.findDOMNode(this.refs[id]);
        let popupDivElement = ReactDOM.findDOMNode(this.refs['popup']);
        if(friendDivElement) {
            let rect = friendDivElement.getBoundingClientRect();
            popupDivElement.style.top= (rect.top - (this.props.friendMenuHeight/2 ))+'px';
            popupDivElement.style.right = (rect.width + 16) + 'px';

            this.state.friends.forEach((friend) => {
                if(friend.id === friendDivElement.id)
                    this.setState({selectedFriend: friend});
            });
        }

        this.setState((prevState) => ({
            popupVisibility : {
                visibility : prevState.popupVisibility.visibility.toLowerCase() === "visible" ? "hidden" : "visible",
                top: popupDivElement.style.top,
                right : popupDivElement.style.right,
                width : this.props.friendMenuWidth+'px',
                height : this.props.friendMenuHeight+'px'
            }
        }));



    }

    componentDidMount() {
        this.initFriends();
    }

    render() {
        let orderedList = this.state.friends.map( friend =>
            <div key={friend.id} ref={friend.id} id={friend.id} className='row ui-friend-div'
                 onMouseEnter={() => this.togglePopupVisibility(friend.id)}
                 onMouseLeave={this.togglePopupVisibility}>

                <div className='col-2'>
                    <img src='../../img/user-profile.png' alt='no' className='ui-friend-profile-picture'/>
                </div>
                <div className='col-8'>
                    <label className='ui-friend-text' >
                        {friend.firstName} {friend.lastName}
                    </label>
                </div>
                <div className='col-2'></div>
            </div>
        );

        let info;
        if(this.state.selectedFriend.menuItems)
             info = this.state.selectedFriend.menuItems.map(menuItem =>
                <div key={menuItem.itemValue} className='row'>
                    <div>
                        <label>{menuItem.itemName}</label><label>{menuItem.itemValue}</label>
                    </div>
                </div>
            );

        let headings = (
            <div className='row'>
                <div className='row'>
                    <h3>{this.state.selectedFriend.firstName} {this.state.selectedFriend.id}</h3>
                </div>
            </div>
        );

        let popup = <div className='ui-friend-menu popup-text' ref='popup' style={this.state.popupVisibility}>
            <div className='row'>
                <div className='col-4 col-t-4'>
                    <img src='../../img/user-profile.png' alt='no' className='ui-friend-menu-profile-picture'/>
                </div>
                <div className='col-8 col-t-8'>
                    {headings}
                    {info}
                </div>
            </div>
        </div>;

        return (
            <div>
                <h4>friends</h4>
                {orderedList}
                <div>
                    {popup}
                </div>
            </div>
        )
    }

}

export default FriendListComponent;