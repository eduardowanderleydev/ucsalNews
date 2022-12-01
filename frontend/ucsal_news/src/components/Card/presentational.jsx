import React, { useState } from "react";

import "./styles.css";

import EditTask from "../modals/EditTask";

import { FaTrashAlt } from "react-icons/fa";
import { AiFillEdit } from "react-icons/ai";

function card({ taskObj, index, deleteTask, updateListArray }) {
  // eslint-disable-next-line react-hooks/rules-of-hooks
  const [modal, setModal] = useState(false);

  const today = new Date();

  const date =
    today.getDate() + "-" + (today.getMonth() + 1) + "-" + today.getFullYear();

  const toggle = () => {
    setModal(!modal);
  };

  const updateTask = (obj) => {
    updateListArray(obj, index)
};
  return (
    <div>
      <div className="card_content">
        <div className="post_content">
          <ul className="card_info_container">
            <li className="card_title">{taskObj.title}</li>
            <li className="card_description">{taskObj.content}</li>
          </ul>
          <div className="card_date_info">
            <div className="card_date_info_position">{`${date}`}</div>
          </div>
        </div>
        <div className="icons_container">
          <div className="icons_area">
            <AiFillEdit size={25} onClick={() => setModal(true)} />
            <FaTrashAlt size={20} onClick={deleteTask} />
          </div>
        </div>
      </div>
      <EditTask modal={modal} toggle={toggle} taskObj={taskObj} updateTask={updateTask} />
    </div>
  );
}

export default card;
