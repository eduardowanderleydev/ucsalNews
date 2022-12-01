import axios from "axios";
import React, { useEffect, useState } from "react";
import Card from "../../../../Card";

import CreateTask from "../../../../modals/CreateTask";

import "./todoList.css";

function TodoList() {
  const [modal, setModal] = useState(false);

  const [taskList, setTaskList] = useState([]);

  const [selectedValue, setSelectedValue] = React.useState([])

  const [id, setId] = React.useState()
  
  useEffect(() => {
    let arr = localStorage.getItem("taskList");

    if (arr) {
      let obj = JSON.parse(arr);
      setTaskList(obj);
    }
  }, []);

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
    setTaskList(taskList)
   
    console.log(taskList)
  };

  React.useEffect(() => {
    function getAllNews() {
      axios.get("http://localhost:8080/news").then((resp) => {
        const {data} = resp
  
        setTaskList(data)
        console.log('setTaskList', data)
      })
    }

    getAllNews()
  },[])

  React.useEffect(() => {
    function getSelectValues(selectedCategory) {
      axios.get("http://localhost:8080/category").then((resp) => {
        const {data} = resp

        setSelectedValue(data)
        setId(selectedCategory)

        console.log('setSelectedValue', data)
      })
    }

    getSelectValues()
  },[])

  const deleteNew = React.useCallback((id) => {
    axios.delete(`http://localhost:8080/news/${id}`).then((resp) => {
        const {data} = resp
        
        console.log(data)
      })
  },[])

 
    function reloadNewsList(id) {
      deleteNew(id)
  
      window.location.reload()
    }

    function handleSearchByCategory (value) {

      value.preventDefault()
      
      
      axios.get(`http://localhost:8080/news/category/${id}`).then((resp) => {
        const {data} = resp
        console.log(data)
      })
    }

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
          <form onSubmit={handleSearchByCategory}>
          <select name='categorias' value={id} onChange={(event) => setId(event.target.value)}>
                <option >selecione a categoria</option>
                {selectedValue.map((category) => (
                    <option  value={category.id}>{category.name}</option>
                ))}   
          </select>

          <button type='submit'>Pesquisar</button>
          </form>
        
          <CreateTask toggle={toggle} modal={modal} save={saveTask} />
         
        </div>
        <div className="post_container">
          {taskList.map((item, index) => (
            <Card taskObj={item} index={index} deleteTask={() => reloadNewsList(item.id)} updateListArray={updateListArray} />
          ))}
        </div>
      </div>
    </>
  );
}

export default TodoList;
