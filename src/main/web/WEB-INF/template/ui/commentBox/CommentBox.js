import React from 'react';
import {render} from 'react-dom';

class CommentBox extends React.Component {

    constructor(props){
        super(props);
        console.log('init constructor');
        this.state = {
                textAreaBorder : {
                    resize: 'none',
                    border: 'none',
                },
                commentBoxBorder : {
                    border : '0.5px solid hsla(0, 100%, 100%, 1)'
                },
                nbrChars: '0',
                labelStyle : {
                    float: 'right',
                    color: 'white'
                }
        }
        this.keyUp = this.keyUp.bind(this);
    }

    componentDidMount() {
        console.log('component did mount.');
    };

    keyUp() {
        const textAreaContentText = this.refs.textArea.value;
        console.log('textArea value: '+textAreaContentText);
        this.setState( () => ({
            nbrChars: textAreaContentText.length
        }) );
    };

    render () {
        return (
            <div>
                <div className='row'>
                    <div className='col-4 col-m-2 col-t-3' />
                    <div className='col-4 col-m-8 col-t-6'>
                        <button className='ui-button col-4 col-m-12 col-t-4'>{this.props.lang1}</button>
                        <button className='ui-button col-4 col-m-12 col-t-4'>{this.props.lang2}</button>
                        <button className='ui-button col-4 col-m-12 col-t-4'>{this.props.lang3}</button>
                    </div>
                    <div className='col-4 col-m-2 col-t-3' />
                </div>
                <div className='row'>
                    <div className='col-4 col-m-2 col-t-6' />
                    <div style={this.state.commentBoxBorder} className='col-4 col-m-8 col-t-6'>
                        <textarea   rows={this.props.nbrRows}
                                    cols={this.props.nbrCols}
                                    placeholder={this.props.placeholder}
                                    style={this.state.textAreaBorder}
                                    className='ui-input-text'
                                    onKeyUp={this.keyUp}
                                    id='textArea'
                                    ref='textArea'
                        />
                        <button>exit</button>
                        <label style={this.state.labelStyle}>{this.state.nbrChars}/1000</label>
                    </div>
                    <div className='col-4 col-m-2 col-t-6' />
                </div>
            </div>
        );
    }
}

export default CommentBox;
