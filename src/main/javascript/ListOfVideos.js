import React from "react"

class ListOfVideos extends React.Component{

    constructor(props){
        super(props)
        this.state = {data: []}
    }

    // this function called by React right after this
    // component is inserted into the DOM and rendered
    async componentDidMount(){
        let json = await fetch("/api/videos").json()
        this.setState({data: json})
    }

   render() {
        return (
            <ul>
                {this.state.data.map(item =>
                    <li>
                        {item.name}
                    </li>)}
            </ul>
        )
    }
}

export default  ListOfVideos