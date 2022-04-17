import React from 'react';
import {Link} from 'react-router-dom';

const bookTerm = (props) => {
    return (
        <tr>
            <td scope={"col"}>{props.term.name}</td>
            <td scope={"col"}>{props.term.category}</td>
            <td scope={"col"}>{props.term.author.name + " " + props.term.author.surname}</td>
            <td scope={"col"}>{props.term.availableCopies}</td>
            <td scope={"col"} className={"text-right"}>
                <a title={"Delete"} className={"btn btn-danger"}
                onClick={() => props.onDelete(props.term.id)}>Delete</a> | <a title={"Mark"} className={"btn btn-primary"}
                   onClick={() => props.markAsTaken(props.term.id)}>Mark</a>
            </td>
        </tr>

    )
}

export default bookTerm;