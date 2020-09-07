package com.example.realboard;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.web.PageableDefault;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RepositoryRestController
public class UserRestController {
    private UserRepository userRepository;


    public UserRestController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public @ResponseBody
    CollectionModel<User> simpleUser(@PageableDefault Pageable pageable){
        Page<User> userList = userRepository.findAll(pageable);

        PagedModel.PageMetadata pageMetadata = new PagedModel.PageMetadata(pageable.getPageSize(), userList.getNumber(),
                userList.getTotalElements());
        PagedModel<User> resources = new PagedModel<>(userList.getContent(), pageMetadata );
        resources.add(linkTo(methodOn(UserRestController.class).simpleUser(pageable)).withSelfRel());
        return resources;
    }
}
