package tn.esprit.spring.service;

import java.util.List;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Post;
import tn.esprit.spring.entities.PostComment;
import tn.esprit.spring.repository.PostCommentRepository;
import tn.esprit.spring.repository.PostRepository;
@Service
public class PostCommentService implements IPostCommentService{

	@Autowired 
	PostCommentRepository postCommentrep;
	@Autowired 
	PostRepository postrep;
	@Autowired 
	IPostService ipostservice;
	@Override
	public PostComment AjoutPostComment(PostComment p) {
		// TODO Auto-generated method stub
		return postCommentrep.save(p);
	}

	@Override
	public void SupprimerPostComment(int Id) {
		// TODO Auto-generated method stub
		postCommentrep.deleteById(Id);
	}

	@Override
	public PostComment PostCommentById(int id) {
		// TODO Auto-generated method stub
		return postCommentrep.findById(id).orElse(null);
	}

	@Override
	public List<PostComment> PostCommentGetAll() {
		// TODO Auto-generated method stub
		return postCommentrep.findAll();
	}

	@Override
	public void PostCommentModifier(PostComment a, int id) {
		// TODO Auto-generated method stub
		postCommentrep.save(a);
	}

	@Override
	public String AjoutCommentinpost(PostComment po, int idpost) {
		// TODO Auto-generated method stub
		Post p=ipostservice.PostById(idpost);
		po.setPost(p);
		postCommentrep.save(po);

		return "comment dans post ajouter";
	}

	@Override
	public void SupprimerMotInterdit(List<PostComment> p) throws Exception {
		// TODO Auto-generated method stub
				String file = "dictionaire.txt";
        BufferedReader br = new BufferedReader(new FileReader(file));
        
            String line;
            while ((line=br.readLine())  != null) {
            System.out.println(line);
          // p= postCommentrep.findAll();
           for (int i=0;i<p.size();i++) {
        	   for(int j=0;i<br.readLine().indexOf(j);j++) {
        	   if(p.equals(br.readLine())) {
        		   postCommentrep.delete((PostComment) p);
        	   }
           }
            }
        }
	}

	public void getDictionaire() throws IOException {
		String file = "dictionaire.txt";
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line;
        while ((line=br.readLine())  != null) {
        System.out.println(line);}
	}
}
