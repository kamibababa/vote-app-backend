package org.example.mapper;

import org.apache.ibatis.annotations.Param;
import org.example.entity.CandidateEntity;
import org.example.entity.UsersEntity;
import org.example.entity.VoteEntity;

import java.util.List;

public interface UsersMapper {
    UsersEntity loginUser(UsersEntity usersEntity);
    UsersEntity getUserById(long uid);

    List<CandidateEntity> getCandidates();
    List<VoteEntity> getVotes();
    int isVote(@Param("current_userid") String current_userid);
    int vote(@Param("current_userid") String current_userid, @Param("cid") String cid);
}
