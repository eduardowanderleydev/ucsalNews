import React, { useEffect, useState } from "react";
import Card from "../../../../Card";

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

  const deleteTask = (index) => {
    let tempList = taskList;
    tempList.splice(index, 1);
    localStorage.setItem("taskList", JSON.stringify(tempList));
    setTaskList(tempList);
    window.location.reload();
  };

  const updateListArray = (obj, index) => {
    let tempList = taskList;
    tempList[index] = obj;
    localStorage.setItem("taskList", JSON.stringify(tempList));
    setTaskList(tempList);
    window.location.reload();
  };

  const toggle = () => {
    setModal(!modal);
  };

  const saveTask = (taskObj) => {
    let tempList = taskList;
    tempList.push(taskObj);
    localStorage.setItem("taskList", JSON.stringify(tempList));
    setModal(false);
    setTaskList(taskList);
  };

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
          {taskList.map((item, index) => (
            <Card taskObj={item} index={index} deleteTask={deleteTask} updateListArray={updateListArray} />
          ))}
        </div>
      </div>
    </>
  );
}

export default TodoList;
