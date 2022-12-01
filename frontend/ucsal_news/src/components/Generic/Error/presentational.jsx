import React from 'react'

import './styles.css'

function Error(props) {

    const {description = 'Aparentemente ocorreu um erro, por favor tente novamente'} = props
    return (
        <div className="error-alert">
            {description}
        </div>
    )
}

export default Error;
