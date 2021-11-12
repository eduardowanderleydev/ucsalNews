import React, { useState } from "react";

import CreateTask from "../../../../modals/CreateTask";

import "./todoList.css";

function TodoList() {
  const [modal, setModal] = useState(false);

  const toggle = () => {
    setModal(!modal);
  };

  return (
    <>
      <div className="todolist_container">
        <div className="todolist_content">
          <h3 className="todolist__title">Todo List</h3>
          <button className="todolist_button" onClick={() => setModal(true)}>
            Create News
          </button>
          <CreateTask toggle={toggle} modal={modal} />
        </div>
        
      </div>
     
    </>
  );
}

export default TodoList;
