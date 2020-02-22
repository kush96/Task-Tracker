import React, { useState } from "react";
import { Modal, Button, Form, Label } from "react-bootstrap";
function CreateTaskModal(props) {
  const [show, setShow] = useState(false);
  const handleClose = () => setShow(false);
  const handleShow = () => setShow(true);

  return (
    <>
      <Button variant="primary" onClick={handleShow}>
        Create
      </Button>

      <Modal
        {...props}
        size="lg"
        aria-labelledby="contained-modal-title-vcenter"
        centered
        show={show}
        onHide={handleClose}
        scrollable
      >
        <Modal.Header closeButton>
          <Modal.Title>Create Issue</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <Form.Group>
            <Form.Label>Project</Form.Label>
            <Form.Control as="select">
              <option>Bug</option>
              <option>Task</option>
              <option>Feature</option>
              <option>Technical Debt</option>
            </Form.Control>
          </Form.Group>
          <Form.Group>
            <Form.Label>Description</Form.Label>
            <Form.Control />
          </Form.Group>
          <Form.Group>
            <Form.Label>Issue Type</Form.Label>
            <Form.Control as="select">
              <option>Bug</option>
              <option>Task</option>
              <option>Feature</option>
              <option>Technical Debt</option>
            </Form.Control>
          </Form.Group>
          <Form.Group>
            <Form.Label>Test Cases</Form.Label>
            <Form.Control as="textarea" rows="3" />
          </Form.Group>
        </Modal.Body>
        <Modal.Footer>
          <Button variant="secondary">Close</Button>
          <Button variant="primary">Save changes</Button>
        </Modal.Footer>
      </Modal>
    </>
  );
}
export default CreateTaskModal;
