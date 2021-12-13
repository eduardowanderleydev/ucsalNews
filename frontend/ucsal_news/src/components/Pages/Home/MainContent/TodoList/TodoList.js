import React, { useEffect, useState } from "react";

import CreateTask from "../../../../modals/CreateTask";

import "./todoList.css";

function TodoList() {
  const [modal, setModal] = useState(false);
  const [taskList, setTaskList] = useState([]);

  useEffect(() => {
    let arr = localStorage.getItem("taskList");

    if (arr) {
      let obj = JSON.parse(arr);
      setTaskList(obj);
    }
  }, []);

  const toggle = () => {
    setModal(!modal);
  };

  const saveTask = (taskObj) => {
    let tempList = taskList;
    tempList.push(taskObj);
    setTaskList(tempList);
    setModal(false);
  };

  const today = new Date();

  const date = today.getDate()+'-'+(today.getMonth()+1)+'-'+today.getFullYear();

  return (
    <>
      <div className="todolist_container">
        <div className="todolist_content">
          <div>
            <div className="todolist__logo"></div>
            <button className="todolist_button" onClick={() => setModal(true)}>
              Create News
            </button>
          </div>
          <CreateTask toggle={toggle} modal={modal} save={saveTask} />
        </div>
        <div className="post_container">
        
          {taskList.map((item) => (
            <div className="card_content">
              <div className="post_content">
                <ul className="card_info_container">
                  <li className="card_title">{item.Name}</li>
                  <li className="card_description">{item.Description}</li>
                </ul>
                <div className="card_date_info">
                <div className="card_date_info_position">
                {`${date}`}
                </div>
              </div>
              </div>
            </div>
          ))}
        </div>
      </div>
    </>
  );
}

export default TodoList;
