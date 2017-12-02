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
            views : [],
            buttonElement: {},
            user : {'first': '', 'last': '', 'email': '', 'pwd': ''}
        };
        this.toggleVisibility = this.toggleVisibility.bind(this);
        this.hidePopup= this.hidePopup.bind(this);
        this.loadFromServer_final= this.loadFromServer_final.bind(this);
        this.onclick = this.onclick.bind(this);
    }


    componentDidMount() {
        console.log('component did mount.');
        this.refs.popupBoxRef.style.width= this.props.width+'px';
        this.refs.popupBoxRef.style.height= this.props.height+'px';

        this.loadFromServer_final();
    }

    loadFromServer_final () {
        // create promise chain using follow

        follow(client , this.props.root, [{rel : 'view'}] )
            // initialize schema for this object [popup]
        // you can omit this next then, if you do not intend to use schema.
            .then(viewsPromise => {
                console.log('viewsPromise: ', viewsPromise.entity);
                return client ({
                    method: 'GET',
                    path :  viewsPromise.entity._links.profile.href ,
                    headers : {'accept' : 'application/schema+json'}
                }).then(schema => {
                    console.log('schema: ', schema.entity);
                    this.schema = schema.entity;
                    return viewsPromise;
                })
            // search and locate unique view model attached to this popup
            // findByName let us find appropriate view mentioned in props.formName
            }).then(viewsPromise => {
                return client ({
                    method : 'GET',
                    path   : viewsPromise.entity._links.search.href+'/findByName?name='+this.props.formName,
                    headers: {'accept': 'application/schema+json'}

                    // returning only one view
                }).then(viewPromise => {
                    console.log('view promise: ', viewPromise.entity);
                    this.setState({views: [viewPromise.entity]});
                    return viewPromise.entity.nodes;

                    // return according nodes
                }).then(nodesPromise => {
                    console.log('nodes: ', nodesPromise.entity);
                    var tab = [] ;
                    for(let inputClazzName in nodesPromise.entity._embedded)
                        if(inputClazzName.toLowerCase() === 'buttonelement')
                            this.setState({buttonElement : nodesPromise.entity._embedded[inputClazzName][0] })
                        else
                            tab= tab.concat(nodesPromise.entity._embedded[inputClazzName]);
                    this.setState({inputs : tab});
                    console.log("new state : ", this.state);
                    return nodesPromise;
                })
            });



    }

    componentDidUpdate(prevProps, prevState, prevContext) {
        if(prevState.buttonElement['type'] ) {
            console.log('view: ', this.state.views[0].formName);
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
            <div className='row' key={input._links.self.href} >
                <Input  input={input} ref={input.id}/>
            </div>
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
                    <button className={this.state.buttonElement.className}
                            type={this.state.buttonElement.type}
                            title={this.state.buttonElement.title}
                            id={this.state.buttonElement.id}
                            // onSubmit={this.onclick}
                            // onClick={this.onclick}

                    >
                        {this.state.buttonElement.content}
                    </button>
                </div>
            </form>
        );



        return (
            <div onKeyUpCapture={this.hidePopup}>

                <button  className='ui-button' onClick={this.toggleVisibility}>
                    {this.props.toggleButtonValue}
                </button>

                <div className='popup popup-text'
                     style={this.state.boxVisibility}
                     ref='popupBoxRef'>
                    {form}
                </div>

            </div>
        );


    }

}

export default Popup;