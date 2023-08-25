import React, { useState } from "react";
import Modal from "components/feed/Modal";
import Slider from "./Slider";
import parse from "html-react-parser";

export default function FeedList({ data }) {
  const [modalOpen, setModalOpen] = useState(false);
  const { u_nickname, likes, content, image_path } = data;

  return (
    <>
      <div className="feedContainer">
        <div className="feedTop">
          <div className="profile">
            <div className="imgContainer">
              <img src="/img/avatar.png" alt="profileImg" />
            </div>
            <span className="nickname">{u_nickname}</span>
          </div>
          <button>팔로우</button>
        </div>

        <Slider imgs={image_path.split(",")} />
        <div className="feedContent">
          <div className="icons">
            <img src="/icon/heart.svg" alt="heart-icon" />
            <img src="/icon/balloon.svg" alt="balloon-icon" />
          </div>
          <p className="likes">좋아요 {likes}개</p>
          {/* <ul className="tags">
            {tags.map((item) => (
              <li>#{item}</li>
            ))}
          </ul> */}
          <p className="feedText">
            <span>{u_nickname}</span> &nbsp;
            {parse(content)}
          </p>
          {/* <div className="comments">
            <p className="more" onClick={() => setModalOpen(true)}>
              View all 33 comments
            </p>
            {comments.slice(0, 2).map((item) => (
              <p className="comment" key={item.userId}>
                <span>{item.nickname}</span>
                {item.text}
              </p>
            ))}
          </div> */}
          <div className="time">한 시간 전</div>
        </div>
      </div>
      {modalOpen && <Modal setModalOpen={setModalOpen} data={data} />}
    </>
  );
}
