import React, { useEffect, useState } from "react";
import { Button, Modal, ModalHeader, ModalBody, ModalFooter } from "reactstrap";

import "./createTask.css";

export function EditTask({ modal, toggle, updateTask, taskObj }) {
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

  useEffect(() => {
    settitleNews(taskObj.title)
    setDescription(taskObj.content)
  },[])

  const handleUpdate = (e) => {
      e.preventDefault();
      let tempObj = {};
      tempObj['title'] = titleNews
      tempObj['content'] = description
      updateTask(tempObj)
  }

  return (
    <Modal isOpen={modal} toggle={toggle} className="modal_container">
      <ModalHeader toggle={toggle}>Edit News</ModalHeader>
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
        <Button color="primary" onClick={handleUpdate}>
          Edit
        </Button>
      </ModalFooter>
    </Modal>
  );
}

export default EditTask;
