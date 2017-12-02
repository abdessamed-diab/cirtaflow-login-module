import React from 'react';
import {render} from 'react-dom';
import Radio from "./Radio";

class Input extends React.Component {
    constructor(props) {
        super(props);
        console.log('Input init constructor');

        this.state = {
            value: this.props.input.value,
            checked: this.props.input.checked
        };

        this.onChange= this.onChange.bind(this);
        this.inputText= this.inputText.bind(this);
    }

    componentDidMount() {
        console.log('Input component did mount.');
    }

    onChange(eventChange) {
        console.log('Input on change.');
        this.setState({value: eventChange.target.value});
        this.setState({checked: eventChange.target.checked})
    }

    inputText() {
        return (
                    <input  type            =   {   this.props.input.type       }
                            name            =   {   this.props.input.name       }
                            autoFocus       =   {   this.props.input.autoFocus  }
                            value           =   {   this.state.value            }
                            autoComplete    =   {  this.props.input.autoComplete}
                            maxLength       =   {   this.props.input.maxLength  }
                            size            =   {   this.props.input.size       }
                            pattern         =   {   this.props.input.pattern    }
                            placeholder     =   {   this.props.input.placeholder}
                    // dir             =   {   this.props.input.selectionDirection}
                         // defaultValue    =   {  this.props.input.defaultValue}
                            autoCapitalize  =   {this.props.input.autoCapitalize}
                            onChange        =   {   this.onChange               }
                            className       =   {   this.props.input.className  }
                            id              =   {   this.props.input.id         }
                            accessKey       =   {   this.props.input.accessKey  }
                            contentEditable =  {this.props.input.contentEditable}
                            dir             =   {   this.props.input.dir        }
                            draggable       =   {   this.props.input.draggable  }
                            lang            =   {   this.props.input.lang       }
                            style           =   {   this.props.input.style      }
                            title           =   {   this.props.input.title      }
                            // translate       =   {   this.props.input.translate  }
                            required        =   {   this.props.input.required   }
                            disabled        =   {   this.props.input.disabled   }
                            readOnly        =   {   this.props.input.readOnly   }
                            hidden          =   {   this.props.input.hidden     }
                            min             =   {   this.props.input.min        }
                            max             =   {   this.props.input.max        }
                            checked         =   {   this.state.checked    }
                            // defaultChecked  =   {this.props.input.defaultChecked}

                    >
                    {this.props.input.content}
                    </input>
        )
    }

    render () {
        switch (this.props.input.type){
            case 'text' :
                return this.inputText();
            case 'number' :
                return this.inputText();
            case 'checkbox' :
                return this.inputText();
            case 'password':
                return this.inputText();
            case 'email':
                return this.inputText();
            case 'date':
                return this.inputText();
            case 'datetime':
                return this.inputText();
            case 'month':
                return this.inputText();
            case 'week':
                return this.inputText();
            case 'time':
                return this.inputText();
            case 'datetime-local':
                return this.inputText();
            case 'radio':
                return <Radio input={this.props.input} />
            default:
                return null;


        }
    }


}

export default Input;