import React from 'react';
import Input from "../node/Input";

const client = require('../../js/client');
const follow= require( '../../js/follow');
const ReactDOM = require('react-dom');

class Popup extends React.Component {

    constructor(props) {
        super(props);
        console.log('init constructor.'+props.width);
        this.state = {
            boxVisibility: {
                visibility: props.visibility
            },
            inputs: [],
            buttons:[],
            views : [],
            user : {'first': '', 'last': '', 'email': '', 'pwd': ''}
        };
        this.toggleVisibility = this.toggleVisibility.bind(this);
        this.hidePopup= this.hidePopup.bind(this);
        this.loafFromServer= this.loafFromServer.bind(this);
        this.onclick = this.onclick.bind(this);
    }


    componentDidMount() {
        console.log('component did mount.');
        this.refs.popupBoxRef.style.width= this.props.width+'px';
        this.refs.popupBoxRef.style.height= this.props.height+'px';

        this.loafFromServer();
    }

    loafFromServer() {
        follow(client, this.props.root, [{rel : 'view'}])
            .then(viewsPromise => {
                return client ({
                    method: 'GET',
                    path  : viewsPromise.entity._links.profile.href,
                    headers : {'accept' : "application/schema+json"}
                }).then(schema => {
                    this.schema= schema.entity;
                    console.log('schema: ', this.schema);
                    return viewsPromise;
                })
            }).then(viewsPromise => {
                return client ({
                    method: 'GET',
                    path : viewsPromise.entity._links.search.href+'/findByName?name='+this.props.formName,
                    headers : {'accept' : 'application/schema+json'}
                }).then(viewPromise => {
                    this.setState({views : [ viewPromise.entity ] });
                    console.log('state view: ', this.state.views);
                    return viewPromise;
                }).then(viewPromise=> {
                    return client ({
                        method: 'GET',
                        path: viewPromise.entity._links.self.href+'?projection=withNodes',
                        headers : {'accept' : 'application/schema+json'}
                    }).then(inputsPromise => {
                        console.log('inputs promise : ', inputsPromise.entity.inputs);
                        this.setState({inputs : inputsPromise.entity.inputs});
                        this.setState({buttons : inputsPromise.entity.buttons});
                    });
                })
            })
    }

    componentDidUpdate(prevProps, prevState, prevContext) {
        if(!prevState.buttons.length >0 ) {
            if(this.state.views[0].formNoValidate) {
                let formSubmit = ReactDOM.findDOMNode(this.refs[this.state.views[0].formName]).value;
                if (!formSubmit)
                    formSubmit = document.getElementById(this.state.views[0].formName);
                console.log('form : ', formSubmit);
                formSubmit.addEventListener("submit", this.onclick);
            }
        }
    }

    toggleVisibility() {
        console.log('toggle visibility.');
        this.adjustPosition();
        this.setState((prevState) => ({
            boxVisibility: {
                visibility: prevState.boxVisibility.visibility.toLowerCase() === 'visible'.toLowerCase() ? 'hidden' : 'visible'
            }
        }));
    }

    hidePopup(event) {
        console.log('hide popup window, key code: '+event.keyCode);
        if(event.keyCode == 27)
            this.toggleVisibility();
    }

    adjustPosition() {
        let boxElement = this.refs.popupBoxRef;
        let windowWidth = window.innerWidth;

        if ((boxElement.getBoundingClientRect().width + boxElement.getBoundingClientRect().left) > windowWidth) {
            boxElement.style.position = 'absolute';
            boxElement.style.left = ((windowWidth / 2) - (boxElement.getBoundingClientRect().width / 2)) + 'px';
            boxElement.style.top = '128px';
        }
    }


    // sending the new created user to the server side in order to save him.
    uploadInput(user) {
        console.log("new value is : ", user);
        follow(client, this.props.root, ['user']).then(userCollection => {
            return client({
                method: 'POST',
                path: userCollection.entity._links.self.href,
                entity: user,
                headers: {'Content-Type': 'application/json'}
            })
        });
    }

    // set up all required values of ACT_ID_USER
    onclick(e) {
        e.preventDefault();
        console.log('on click', this.state.inputs);
        this.state.inputs.forEach(input => {
            console.log("inout : ", input['name']);
            this.state.user[input.name] = ReactDOM.findDOMNode(this.refs[input.id]).value;

        });

        this.state.user['id'] = this.state.user['first']+'.'+this.state.user['last'];
        this.uploadInput(this.state.user);

        return false;
    }

    render () {
        let inputs = this.state.inputs.map(input =>
            <div className='row' key={input.id} >
                <Input  input={input} ref={input.id}/>
            </div>
        );

        let buttons = this.state.buttons.map(button =>
            <button className={button.className}
                    type={button.type}
                    key={button.content}
            >
                {button.content}
            </button>
        );

        let form   = this.state.views.map( view=>
            <form key={view._links.self.href}
                  encType={view.formEncType}
                  action={view.formAction}
                  method={view.formMethod}
                  ref={view.formName}
                  id={view.formName}
            >
                <h4>{this.props.popupHeaderText}</h4>

                <div className="col-1" ></div>
                    <div className='col-10'>
                        {inputs}
                    </div>
                <div className="col-1" ></div>

                <div className='bottom'>
                    {buttons}
                </div>
            </form>
        );

        return (
            <div onKeyUpCapture={this.hidePopup}>

                {/*top button toggle visibility of this popup window*/}
                <button  className='ui-button' onClick={this.toggleVisibility}>
                    {this.props.toggleButtonValue}
                </button>

                {/*add ref add for adjusting the position of the window*/}
                <div className='popup popup-text'
                     style={this.state.boxVisibility}
                     ref='popupBoxRef'>
                    {form}
                </div>
            </div>
        )

    }

}

export default Popup;