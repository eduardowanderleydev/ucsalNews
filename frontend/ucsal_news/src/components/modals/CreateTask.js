import axios from "axios";
import React, { useState } from "react";
import { Button, Modal, ModalHeader, ModalBody, ModalFooter } from "reactstrap";

import "./createTask.css";

export function CreateTask({ modal, toggle, save }) {
  const [titleNews, settitleNews] = useState("");
  const [description, setDescription] = useState("");
  const [id, setId] = useState("")

  const handleChange = (e) => {
    const { name, value } = e.target;

    if (name === "title") {
      settitleNews(value);
    } else if (name === "content") {
      setDescription(value);
    } else {
      setId(value)
    }
  };

  const handleSave = async () => {
    let taskObj = {}
    taskObj['title'] = titleNews
    taskObj['content'] = description
    taskObj['author_id'] = 1
    save(taskObj)
    await addNew(taskObj)
  }

  const addNew = async data => await axios.post("http://localhost:8080/news" , data)

  return (
    <Modal isOpen={modal} toggle={toggle} className="modal_container">
      <ModalHeader toggle={toggle}>Create News</ModalHeader>
      <ModalBody>
        <form onSubmit={addNew}>
          <div className="form-group">
            <label className="label_task_form">Title</label>
            <input
              className="form-control"
              type="text"
              value={titleNews}
              name="title"
              onChange={handleChange}
            />
          </div>

          <div className="form-group">
            <label className="label_task_form">Description</label>
            <textarea
              rows="5"
              className="form-control"
              value={description}
              name="content"
              onChange={handleChange}
            ></textarea>
          </div>

            <input
              hidden
              className="form-control"
              type="text"
              value={1}
              name="author_id"
            />

        </form>
      </ModalBody>
      <ModalFooter>
        <Button color="secondary" onClick={toggle}>
          Cancel
        </Button>{" "}
        <Button color="primary" onClick={handleSave}>
          Create
        </Button>
      </ModalFooter>
    </Modal>
  );
}

export default CreateTask;
