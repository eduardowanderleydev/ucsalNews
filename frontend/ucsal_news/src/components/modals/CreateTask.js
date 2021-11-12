import React from "react";
import { Button, Modal, ModalHeader, ModalBody, ModalFooter } from "reactstrap";

import './createTask.css'

export function CreateTask({ modal, toggle }) {
  return (
    <Modal isOpen={modal} toggle={toggle} className="modal_container">
      <ModalHeader toggle={toggle}>Create News</ModalHeader>
      <ModalBody>
        <form>
          <input type ="text">
          </input>
        </form>
      </ModalBody>
      <ModalFooter>
        <Button color="secondary" onClick={toggle}>
          Cancel
        </Button> {' '}
        <Button color="primary" onClick={toggle}>
          Create
        </Button> 
      </ModalFooter>
    </Modal>
  );
}

export default CreateTask;
