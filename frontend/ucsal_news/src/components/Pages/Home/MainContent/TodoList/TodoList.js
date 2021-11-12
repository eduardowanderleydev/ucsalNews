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

  return (
    <>
      <div className="todolist_container">
        <div className="todolist_content">
          <div>
            <h3 className="todolist__title">UCSAL NEW</h3>
            <button className="todolist_button" onClick={() => setModal(true)}>
              Create News
            </button>
          </div>
          <CreateTask toggle={toggle} modal={modal} save={saveTask} />
        </div>
        <div className="post_container">
          {taskList.map((item) => (
            <div className="card">
              <div className="post_content">
                <ul>
                  <li className="card_title">{item.Name}</li>
                  <div class="cart_bar">
                    <div class="emptybar"></div>
                    <div class="filledbar"></div>
                  </div>
                  <li className="card_description">{item.Description}</li>
                </ul>
              </div>
            </div>
          ))}
        </div>
      </div>
    </>
  );
}

export default TodoList;
