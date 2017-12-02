import React from 'react';
import {render} from 'react-dom'

class Radio extends React.Component {
    constructor(props) {
        super(props);
        console.log("Radio constructor.");

        this.onChange= this.onChange.bind(this);
    }

    componentDidMount() {
        console.log('component did mount.');
    }

    onChange(changeEvent) {
        console.log('Radio on change.');
    }

    // create an uncontrolled element, see defaultChecked property instead of checked property.
    render () {
        return (
            <div>
                <input  type            =   {   this.props.input.type       }
                        name            =   {   this.props.input.name       }
                        autoFocus       =   {   this.props.input.autoFocus  }
                        value           =   {   this.props.input.value      }
                        autoComplete    =   {   this.props.input.autoComplete}
                        maxLength       =   {   this.props.input.maxLength  }
                        size            =   {   this.props.input.size       }
                        pattern         =   {   this.props.input.pattern    }
                        placeholder     =   {   this.props.input.placeholder}
                        autoCapitalize  =   {   this.props.input.autoCapitalize}
                        onChange        =   {   this.onChange               }
                        className       =   {   this.props.input.className  }
                        id              =   {   this.props.input.id         }
                        accessKey       =   {   this.props.input.accessKey  }
                        contentEditable =   {   this.props.input.contentEditable}
                        dir             =   {   this.props.input.dir        }
                        draggable       =   {   this.props.input.draggable  }
                        lang            =   {   this.props.input.lang       }
                        style           =   {   this.props.input.style      }
                        title           =   {   this.props.input.title      }
                        required        =   {   this.props.input.required   }
                        disabled        =   {   this.props.input.disabled   }
                        readOnly        =   {   this.props.input.readOnly   }
                        hidden          =   {   this.props.input.hidden     }
                        min             =   {   this.props.input.min        }
                        max             =   {   this.props.input.max        }
                        // checked         =   {   this.props.input.checked    }
                        defaultChecked  =   {   this.props.input.defaultChecked}

                />
                {this.props.input.content}
            </div>
        )
    }
}

export default Radio;