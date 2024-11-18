package org.example.controller;

import org.example.entity.CandidateEntity;
import org.example.entity.UsersEntity;
import org.example.entity.VoteEntity;
import org.example.mapper.UsersMapper;
import org.example.response.ApiResponse;
import org.example.utils.JwtService;
import org.example.utils.UserUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
public class HelloController {
    @Resource
    UsersMapper usersMapper;
    @Resource
    JwtService jwtService;
    @GetMapping("/get_candidate")
    public ApiResponse<List<CandidateEntity>> getCandidate(){
        List<CandidateEntity> candidates = usersMapper.getCandidates();
        return ApiResponse.success(candidates);
    }
    @GetMapping("/get_vote_result")
    public ApiResponse<List<VoteEntity>> getVoteResult(){
        List<VoteEntity> votes = usersMapper.getVotes();
        return ApiResponse.success(votes);
    }
    @PostMapping("/vote/{cid}")
    public ApiResponse<String> vote(@PathVariable String cid){
        UsersEntity result = UserUtils.getLoginUser();
        if(usersMapper.isVote(result.getId().toString())==0){
            usersMapper.vote(result.getId().toString(),cid);;
            return ApiResponse.success(200,"投票成功");
        }
        else{
            return ApiResponse.error(1000,"已经投过票");
        }
    }
    @PostMapping("/login")
    public ApiResponse<String> loginUser(@RequestBody UsersEntity usersInfo) throws Exception {
        UsersEntity usersEntity = usersMapper.loginUser(usersInfo);
        if(usersEntity != null){
            String token = jwtService.toToken(usersEntity);
            return ApiResponse.success(token);
        }
        else{
            throw new Exception("login failed");
        }
    }
}
