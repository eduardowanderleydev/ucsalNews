import React, { useState } from "react";
import { Button, Modal, ModalHeader, ModalBody, ModalFooter } from "reactstrap";

import "./createTask.css";

export function CreateTask({ modal, toggle, save }) {
  const [titleNews, settitleNews] = useState("");
  const [description, setDescription] = useState("");

  const handleChange = (e) => {
    const { name, value } = e.target;

    if (name === "titleNews") {
      settitleNews(value);
    } else {
      setDescription(value);
    }
  };

  const handleSave = () => {
    let taskObj = {}
    taskObj['Name'] = titleNews
    taskObj['Description'] = description
    save(taskObj)
  }

  return (
    <Modal isOpen={modal} toggle={toggle} className="modal_container">
      <ModalHeader toggle={toggle}>Create News</ModalHeader>
      <ModalBody>
        <form>
          <div className="form-group">
            <label className="label_task_form">Title</label>
            <input
              className="form-control"
              type="text"
              value={titleNews}
              name="titleNews"
              onChange={handleChange}
            />
          </div>

          <div className="form-group">
            <label className="label_task_form">Description</label>
            <textarea
              rows="5"
              className="form-control"
              value={description}
              name="descriptionNews"
              onChange={handleChange}
            ></textarea>
          </div>
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
