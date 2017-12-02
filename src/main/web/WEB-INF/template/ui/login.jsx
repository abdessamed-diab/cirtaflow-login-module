import React from 'react';
import {render} from 'react-dom';

import CommentBox from './commentBox/CommentBox.js'
import Popup from "./dialog/Popup.js";

class App extends React.Component {
  render () {
    return (
        <div>
            <CommentBox nbrRows={3} nbrCols={50} placeholder='enter some text.'
                        lang1="english" lang2="french" lang3="arabic"
            />
        </div>
    );
  }
}

// render(<App/>, document.getElementById('comment-box'));
render(
    <Popup visibility='visible'
           toggleButtonValue='register'
           width='300'
           height='600'
           popupHeaderText='header text'
           root='/api'
           formName="register_form"
    >
    </Popup>,
    document.getElementById('popup')
);
