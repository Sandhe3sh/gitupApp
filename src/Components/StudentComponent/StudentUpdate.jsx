import React, { useState, useEffect } from 'react';
import { updateStudent, getStudentById } from "../../Services/StudentService";
import { useParams, useNavigate } from 'react-router-dom';

const StudentUpdate = () => {
    const [student, setStudent] = useState({
        registrationNumber: 0,
        studentName: "",
        address: "",
        mobile: "",
        studentLevel: "",
        username: "",
        email: "",
        status: "",
    });

    const navigate = useNavigate();
    const { studentId } = useParams();
    const parsedStudentId = Number(studentId); // Ensure it's a number

    useEffect(() => {
        getStudentById(parsedStudentId)
            .then(res => {
                console.log("Fetched student:", res.data);
                setStudent(res.data);
            })
            .catch(err => {
                console.error("Error fetching student data:", err);
                alert("Failed to fetch student data.");
            });
    }, [parsedStudentId]);

    const onChangeHandler = (event) => {
        const { name, value } = event.target;
        setStudent(values => {
            const updatedStudent = { ...values, [name]: value };
            console.log("Updated Student:", updatedStudent);
            return updatedStudent;
        });
    };

    const studentSave = (event) => {
        event.preventDefault();

        updateStudent(student)
            .then(response => {
                console.log("Update response:", response); // Log response for debugging
                alert("Student is Updated Successfully!");
                navigate('/AdminMenu');  // Redirect to AdminMenu page after update
            })
            .catch(error => {
                console.error("Update failed:", error.response || error); // Log detailed error
                alert("Update failed! Please check the console.");
            });
    };

    // Function to handle the "Return" button click, it navigates to the previous page
    const handleReturn = () => {
        navigate('/AdminMenu');  // Or you can go to another page
    };

    return (
        <div>
            <br />
            <div className="container">
                <div className="row">
                    <div className="card col-md-12 offset-md-3 offset-md-3">
                        <div className="card-body">
                            <h2 className="text-center"><u>Student Update</u></h2>
                            <br />
                            <div className="form-group">
                                <label>Registration Number: </label>
                                <input
                                    placeholder="registrationNumber"
                                    name="registrationNumber"
                                    className="form-control"
                                    value={student.registrationNumber}
                                    readOnly // Prevent accidental edits
                                />
                            </div>
                            <div className="form-group">
                                <label>Username: </label>
                                <input
                                    placeholder="username"
                                    name="username"
                                    className="form-control"
                                    value={student.username}
                                    onChange={onChangeHandler}
                                />
                            </div>
                            <div className="form-group">
                                <label>Student Name: </label>
                                <input
                                    placeholder="studentName"
                                    name="studentName"
                                    className="form-control"
                                    value={student.studentName}
                                    onChange={onChangeHandler}
                                />
                            </div>
                            <div className="form-group">
                                <label>Email: </label>
                                <input
                                    placeholder="email"
                                    name="email"
                                    className="form-control"
                                    value={student.email}
                                    onChange={onChangeHandler}
                                />
                            </div>
                            <div className="form-group">
                                <label>Address: </label>
                                <input
                                    placeholder="address"
                                    name="address"
                                    className="form-control"
                                    value={student.address}
                                    onChange={onChangeHandler}
                                />
                            </div>
                            <div className="form-group">
                                <label>Mobile: </label>
                                <input
                                    placeholder="mobile"
                                    name="mobile"
                                    className="form-control"
                                    value={student.mobile}
                                    onChange={onChangeHandler}
                                />
                            </div>
                            <div className="form-group">
                                <label>Student Level: </label>
                                <input
                                    placeholder="studentLevel"
                                    name="studentLevel"
                                    className="form-control"
                                    value={student.studentLevel}
                                    onChange={onChangeHandler}
                                />
                            </div>
                            <div className="form-group">
                                <label>Status: </label>
                                <input
                                    placeholder="status"
                                    name="status"
                                    className="form-control"
                                    value={student.status}
                                    onChange={onChangeHandler}
                                />
                            </div>

                            <button className="btn btn-success" onClick={studentSave}>Save</button>
                            <button className="btn btn-secondary ml-2" onClick={handleReturn}>Return</button> {/* Return button */}
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default StudentUpdate;