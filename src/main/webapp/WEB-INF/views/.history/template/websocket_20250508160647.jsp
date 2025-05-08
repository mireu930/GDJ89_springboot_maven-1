<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	//웹소켓관련코드
	const websocket = new WebSocket("/ws/chat")
	const memoSend = document.getElementById("memoSend");
	const memoContents = document.getElementById("memoContents")
	const memoReceiver = document.getElementById("memoReceiver")
	const readMessage = document.getElementById("readMessage")
	
	memoSend.addEventListener("click",()=>{
		let m = new Message();
	
		m.body=memoContents.value;
	
		m.receiver=memoReceiver.value;
		m.status=3;
		m.date=new Date();
		
		websocket.send(JSON.stringify(m))
	})
	
	class Message {
		sender="";
		body="";
		receiver="";
		date="";
		status="0"
	}
</script>