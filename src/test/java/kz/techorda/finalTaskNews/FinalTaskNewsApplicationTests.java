package kz.techorda.finalTaskNews;

import kz.techorda.finalTaskNews.dto.*;
import kz.techorda.finalTaskNews.mapper.*;
import kz.techorda.finalTaskNews.models.*;
import kz.techorda.finalTaskNews.repository.*;
import kz.techorda.finalTaskNews.service.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
class TestApp{

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserService userService;

	@Autowired
	private PermissionRepository permissionRepository;

	@Autowired
	private PermissionMapper permissionMapper;

	@Autowired
	private PermissionService permissionService;

	@Autowired
	private PostMapper postMapper;

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private PostService postService;

	@Autowired
	private NewsCategoryRepository newsCategoryRepository;

	@Autowired
	private NewsCategoryMapper newsCategoryMapper;

	@Autowired
	private NewsCategoryService newsCategoryService;

	@Autowired
	private CommentRepository commentRepository;

	@Autowired
	private CommentMapper commentMapper;

	@Autowired
	private CommentService commentService;


	@Test
	void checkToUserDto(){

		Permission permission = new Permission();
		permission.setId(1L);
		permission.setRole("ROLE_ADMIN");
		List<Permission> permissionList = new ArrayList<>();
		permissionList.add(permission);

		User user = new User();
		user.setId(5L);
		user.setFullName("Ali");
		user.setEmail("ali@gamil.com");
		user.setBio("My name is Ali");
		user.setBirthdate("2023-07-13");
		user.setDeleteApplication(false);
		user.setPermissions(permissionList);

		UserDTO userDTO  =  userMapper.toUserDto(user);

		Assertions.assertNotNull(userDTO);
		Assertions.assertEquals(user.getId(), userDTO.getId());
		Assertions.assertEquals(user.getEmail(), userDTO.getEmail());
		Assertions.assertEquals(user.getFullName(), userDTO.getFullName());
		Assertions.assertEquals(user.getBirthdate(), userDTO.getBirthdate());
		Assertions.assertEquals(user.getBio(), userDTO.getBio());
		Assertions.assertEquals(user.getDeleteApplication(), userDTO.getDeleteApplication());

		List<Permission> permissions = user.getPermissions();
		List<PermissionDTO> permissionDTOs = userDTO.getPermissions();

		Assertions.assertEquals(permissions.size(), permissionDTOs.size());

		for (int i = 0; i < permissions.size(); i++) {
			Permission permission1 = permissions.get(i);
			PermissionDTO permissionDTO1 = permissionDTOs.get(i);

			Assertions.assertEquals(permission1.getId(), permissionDTO1.getId());
			Assertions.assertEquals(permission1.getRole(), permissionDTO1.getRole());
		}

	}


	@Test
	void checkToUserModel() {
		PermissionDTO permissionDTO = new PermissionDTO();
		permissionDTO.setId(1L);
		permissionDTO.setRole("ROLE_ADMIN");
		List<PermissionDTO> permissionDTOList = new ArrayList<>();
		permissionDTOList.add(permissionDTO);

		UserDTO userDTO = new UserDTO();
		userDTO.setId(5L);
		userDTO.setFullName("Ali");
		userDTO.setEmail("ali@gamil.com");
		userDTO.setBio("My name is Ali");
		userDTO.setBirthdate("2023-07-13");
		userDTO.setDeleteApplication(false);
		userDTO.setPermissions(permissionDTOList);

		User user = userMapper.toUserModel(userDTO);

		Assertions.assertNotNull(user);

		Assertions.assertEquals(userDTO.getId(), user.getId());
		Assertions.assertEquals(userDTO.getEmail(), user.getEmail());
		Assertions.assertEquals(userDTO.getFullName(), user.getFullName());
		Assertions.assertEquals(userDTO.getBirthdate(), user.getBirthdate());
		Assertions.assertEquals(userDTO.getBio(), user.getBio());
		Assertions.assertEquals(userDTO.getDeleteApplication(), user.getDeleteApplication());

		List<Permission> permissions = user.getPermissions();
		List<PermissionDTO> permissionDTOs = userDTO.getPermissions();

		Assertions.assertEquals(permissions.size(), permissionDTOs.size());

		for (int i = 0; i < permissions.size(); i++) {
			Permission permission1 = permissions.get(i);
			PermissionDTO permissionDTO1 = permissionDTOs.get(i);

			Assertions.assertEquals(permissionDTO1.getId(), permission1.getId());
			Assertions.assertEquals(permissionDTO1.getRole(), permission1.getRole());
		}
	}

	@Test
	void testToUserDtoList() {
		Permission permission = new Permission();
		permission.setId(1L);
		permission.setRole("ROLE_ADMIN");
		List<Permission> permissionList = new ArrayList<>();
		permissionList.add(permission);

		User user1 = new User();
		user1.setId(5L);
		user1.setFullName("Ali");
		user1.setEmail("ali@gamil.com");
		user1.setBio("My name is Ali");
		user1.setBirthdate("2023-07-13");
		user1.setDeleteApplication(false);
		user1.setPermissions(permissionList);

		User user2 = new User();
		user2.setId(4L);
		user2.setFullName("lee");
		user2.setEmail("lee@gamil.com");
		user2.setBio("My name is lee");
		user2.setBirthdate("2022-07-15");
		user2.setDeleteApplication(true);
		user2.setPermissions(permissionList);

		List<User> userList  = new ArrayList<>();
		userList.add(user1);
		userList.add(user2);

		List<UserDTO> userDTOList = userMapper.toUserDtoList(userList);

		Assertions.assertNotNull(userDTOList);
		Assertions.assertEquals(2, userDTOList.size());

		Assertions.assertEquals(5L, userDTOList.get(0).getId());
		Assertions.assertEquals("Ali", userDTOList.get(0).getFullName());
		Assertions.assertEquals("ali@gamil.com", userDTOList.get(0).getEmail());
		Assertions.assertEquals("2023-07-13", userDTOList.get(0).getBirthdate());
		Assertions.assertEquals("My name is Ali", userDTOList.get(0).getBio());
		Assertions.assertEquals(false, userDTOList.get(0).getDeleteApplication());

		List<PermissionDTO> permissionDTOS = userDTOList.get(0).getPermissions();

		Assertions.assertEquals(permissionList.size(), permissionDTOS.size());

		for (int i = 0; i < permissionDTOS.size(); i++) {
			Permission permission1 = permissionList.get(i);
			PermissionDTO permissionDTO1 = permissionDTOS.get(i);

			Assertions.assertEquals(permissionDTO1.getId(), permission1.getId());
			Assertions.assertEquals(permissionDTO1.getRole(), permission1.getRole());
		}

		Assertions.assertEquals(4L, userDTOList.get(1).getId());
		Assertions.assertEquals("lee", userDTOList.get(1).getFullName());
		Assertions.assertEquals("lee@gamil.com", userDTOList.get(1).getEmail());
		Assertions.assertEquals("2022-07-15", userDTOList.get(1).getBirthdate());
		Assertions.assertEquals("My name is lee", userDTOList.get(1).getBio());
		Assertions.assertEquals(true, userDTOList.get(1).getDeleteApplication());

		List<PermissionDTO> permissionDTOs = userDTOList.get(1).getPermissions();

		Assertions.assertEquals(permissionList.size(), permissionDTOs.size());

		for (int i = 0; i < permissionDTOs.size(); i++) {
			Permission permission1 = permissionList.get(i);
			PermissionDTO permissionDTO1 = permissionDTOs.get(i);

			Assertions.assertEquals(permissionDTO1.getId(), permission1.getId());
			Assertions.assertEquals(permissionDTO1.getRole(), permission1.getRole());
		}


	}

	@Test
	void testToUserModelList() {

		PermissionDTO permissionDTO = new PermissionDTO();
		permissionDTO.setId(1L);
		permissionDTO.setRole("ROLE_ADMIN");
		List<PermissionDTO> permissionDTOList = new ArrayList<>();
		permissionDTOList.add(permissionDTO);

		UserDTO userDTO1 = new UserDTO();
		userDTO1.setId(5L);
		userDTO1.setFullName("Ali");
		userDTO1.setEmail("ali@gamil.com");
		userDTO1.setBio("My name is Ali");
		userDTO1.setBirthdate("2023-07-13");
		userDTO1.setDeleteApplication(false);
		userDTO1.setPermissions(permissionDTOList);

		UserDTO userDTO2 = new UserDTO();
		userDTO2.setId(4L);
		userDTO2.setFullName("lee");
		userDTO2.setEmail("lee@gamil.com");
		userDTO2.setBio("My name is lee");
		userDTO2.setBirthdate("2022-07-15");
		userDTO2.setDeleteApplication(true);
		userDTO2.setPermissions(permissionDTOList);

		List<UserDTO> userDTOList  = new ArrayList<>();
		userDTOList.add(userDTO1);
		userDTOList.add(userDTO2);

		List<User> userList = userMapper.toUserModelList(userDTOList);

		Assertions.assertNotNull(userList);
		Assertions.assertEquals(2, userList.size());

		Assertions.assertEquals(5L, userList.get(0).getId());
		Assertions.assertEquals("Ali", userList.get(0).getFullName());
		Assertions.assertEquals("ali@gamil.com", userList.get(0).getEmail());
		Assertions.assertEquals("2023-07-13", userList.get(0).getBirthdate());
		Assertions.assertEquals("My name is Ali", userList.get(0).getBio());
		Assertions.assertEquals(false, userList.get(0).getDeleteApplication());

		List<Permission> permissions = userList.get(0).getPermissions();

		Assertions.assertEquals(permissionDTOList.size(), permissions.size());

		for (int i = 0; i < permissions.size(); i++) {
			PermissionDTO permission1 = permissionDTOList.get(i);
			Permission permissionDTO1 = permissions.get(i);

			Assertions.assertEquals(permissionDTO1.getId(), permission1.getId());
			Assertions.assertEquals(permissionDTO1.getRole(), permission1.getRole());
		}

		Assertions.assertEquals(4L, userList.get(1).getId());
		Assertions.assertEquals("lee", userList.get(1).getFullName());
		Assertions.assertEquals("lee@gamil.com", userList.get(1).getEmail());
		Assertions.assertEquals("2022-07-15", userList.get(1).getBirthdate());
		Assertions.assertEquals("My name is lee", userList.get(1).getBio());
		Assertions.assertEquals(true, userList.get(1).getDeleteApplication());

		List<Permission> permissions1 = userList.get(1).getPermissions();

		Assertions.assertEquals(permissionDTOList.size(), permissions1.size());

		for (int i = 0; i < permissions1.size(); i++) {
			PermissionDTO permission1 = permissionDTOList.get(i);
			Permission permissionDTO1 = permissions1.get(i);

			Assertions.assertEquals(permissionDTO1.getId(), permission1.getId());
			Assertions.assertEquals(permissionDTO1.getRole(), permission1.getRole());
		}

	}


	@Test
	void checkInsertUserIntoDb(){

		permissionRepository.deleteAll();
		userRepository.deleteAll();

		Permission permissionUser = new Permission();
		permissionUser.setRole("ROLE_USER");
		permissionRepository.save(permissionUser);

		User user = new User();
		user.setFullName("Ali");
		user.setEmail("ali@gamil.com");
		user.setBio("My name is Ali");
		user.setBirthdate("2023-07-13");
		user.setPassword("qwerty");

		User newUser = userService.addUser(user);

		Assertions.assertNotNull(newUser.getId());
		Assertions.assertNotNull(newUser.getDeleteApplication());
		Assertions.assertNotNull(newUser.getPermissions());
		Assertions.assertEquals(user.getEmail(), newUser.getEmail());
		Assertions.assertEquals(user.getFullName(), newUser.getFullName());
		Assertions.assertEquals(user.getBirthdate(), newUser.getBirthdate());
		Assertions.assertEquals(user.getBio(), newUser.getBio());
		userService.deleteUser(newUser.getId());
		permissionRepository.deleteAll();


	}

	@Test
	void checkGetUser(){

		userRepository.deleteAll();
		permissionRepository.deleteAll();

		Permission permissionUser = new Permission();
		permissionUser.setRole("ROLE_USER");
		permissionRepository.save(permissionUser);

		User user = new User();
		user.setFullName("Ali");
		user.setEmail("ali@gamil.com");
		user.setBio("My name is Ali");
		user.setBirthdate("2023-07-13");
		user.setPassword("qwerty");


		UserDTO currentUser = userMapper.toUserDto(userService.addUser(user));

		UserDTO newUser = userService.getUser(currentUser.getId());

		Assertions.assertEquals(currentUser.getId(), newUser.getId());
		Assertions.assertEquals(currentUser.getEmail(), newUser.getEmail());
		Assertions.assertEquals(currentUser.getFullName(), newUser.getFullName());
		Assertions.assertEquals(currentUser.getBirthdate(), newUser.getBirthdate());
		Assertions.assertEquals(currentUser.getBio(), newUser.getBio());
		Assertions.assertEquals(currentUser.getDeleteApplication(), newUser.getDeleteApplication());

		List<PermissionDTO> currentUserPermission = currentUser.getPermissions();
		List<PermissionDTO> newUserPermission = newUser.getPermissions();

		Assertions.assertEquals(currentUserPermission.size(), newUserPermission.size());

		for (int i = 0; i < currentUserPermission.size(); i++) {
			PermissionDTO permission1 = currentUserPermission.get(i);
			PermissionDTO permission2 = newUserPermission.get(i);

			Assertions.assertEquals(permission1.getId(), permission2.getId());
			Assertions.assertEquals(permission1.getRole(), permission2.getRole());
		}

		userRepository.deleteAll();
		permissionRepository.deleteAll();

	}


	@Test
	void checkChangeDeleteApplication(){

		userRepository.deleteAll();


		User user = new User();
		user.setFullName("Ali");
		user.setEmail("ali@gamil.com");
		user.setBio("Мy name is Ali");
		user.setBirthdate("2023-07-13");
		user.setPassword("qwerty");

		User newUser = userRepository.save(user);

		UserDTO userDTO = userMapper.toUserDto(newUser);
		userDTO.setDeleteApplication(true);

		UserDTO updatedUserDTO = userService.changeDeleteApplication(userDTO);

		Assertions.assertTrue(updatedUserDTO.getDeleteApplication());

		userService.deleteUser(newUser.getId());


	}

	@Test
	void checkDeletingUser(){

		User user = new User();
		user.setFullName("Ali");
		user.setEmail("ali@gamil.com");
		user.setBio("Мy name is Ali");
		user.setBirthdate("2023-07-13");
		user.setPassword("qwerty");


		User newUser = userRepository.save(user);

        Assertions.assertNotNull(newUser);

		userService.deleteUser(newUser.getId());

		Assertions.assertFalse(userRepository.existsById(newUser.getId()));

	}

	@Test
	void checkAddUserRole(){

		userRepository.deleteAll();
		permissionRepository.deleteAll();

		Permission permissionUser = new Permission();
		permissionUser.setRole("ROLE_USER");
		permissionRepository.save(permissionUser);

		Permission permission = new Permission();
		permission.setRole("ROLE_SUPER_ADMIN");
		Permission newPermission  = permissionRepository.save(permission);

		User user = new User();
		user.setFullName("Ali");
		user.setEmail("ali@gamil.com");
		user.setBio("I am Ali");
		user.setBirthdate("2023-07-13");
		user.setPassword("qwerty");

		User newUser = userService.addUser(user);

		UserDTO userDTO = userMapper.toUserDto(newUser);

		List<PermissionDTO> permissions = new ArrayList<>();
		permissions.add(permissionMapper.toPermissionDto(newPermission));
		userDTO.setPermissions(permissions);

		UserDTO updatedUserDTO = userService.addPermissions(userDTO);

		Assertions.assertTrue(updatedUserDTO.getPermissions().stream()
				.anyMatch(p -> p.getRole().equals("ROLE_SUPER_ADMIN")));

		userRepository.deleteAll();
		permissionRepository.deleteAll();
	}

	@Test
	void testUpdateUser() {

		User user = new User();
		user.setFullName("Ali");
		user.setEmail("ali@gmaile.com");
		user.setBirthdate("1990-01-01");
		user.setBio("I am Ali");
		user.setPassword("password123");

		User newUser = userRepository.save(user);
		Assertions.assertNotNull(newUser.getId());

		newUser.setEmail("updateAli@gmaile.com");
		newUser.setFullName("Updated Name");
		newUser.setBirthdate("1995-05-05");
		newUser.setBio("Updated Bio");
		User updatedUser = userService.updateUser(newUser);
		Assertions.assertNotNull(updatedUser);


		UserDTO updatedUserDTO = userService.getUser(updatedUser.getId());
		Assertions.assertEquals("updateAli@gmaile.com", updatedUserDTO.getEmail());
		Assertions.assertEquals("Updated Name", updatedUserDTO.getFullName());
		Assertions.assertEquals("1995-05-05", updatedUserDTO.getBirthdate());
		Assertions.assertEquals("Updated Bio", updatedUserDTO.getBio());

		userRepository.deleteAll();

	}


	@Test
	void testGetAllUsers() {

		User user1 = new User();
		user1.setFullName("User One");
		user1.setEmail("user1@example.com");
		user1.setBirthdate("1990-01-01");
		user1.setBio("I'm User One");
		user1.setPassword("password123");

		User user2 = new User();
		user2.setFullName("User Two");
		user2.setEmail("user2@example.com");
		user2.setBirthdate("1995-05-05");
		user2.setBio("I'm User Two");
		user2.setPassword("password456");

		userRepository.save(user1);
		userRepository.save(user2);

		List<UserDTO> users = userService.getAllUsers();


		Assertions.assertFalse(users.isEmpty());
		Assertions.assertTrue(users.stream().anyMatch(u -> u.getFullName().equals("User One")));
		Assertions.assertTrue(users.stream().anyMatch(u -> u.getFullName().equals("User Two")));

		userRepository.deleteAll();

	}

	@Test
	void testToPostDto() {

		User user = new User();
		user.setId(5L);
		user.setFullName("Ali");
		user.setEmail("ali@gamil.com");
		user.setBio("My name is Ali");
		user.setBirthdate("2023-07-13");
		user.setDeleteApplication(false);

		NewsCategory newsCategory  = new NewsCategory();
		newsCategory.setId(1L);
		newsCategory.setName("Sport");

		Post post = new Post();
		post.setId(1L);
		post.setTitle("Test Post");
		post.setContent("This is a test post content");
		post.setPostTime("2023-08-08 15:42:14");
		post.setUser(user);
		post.setNewsCategory(newsCategory);

		PostDTO postDTO = postMapper.toPostDto(post);

		Assertions.assertNotNull(postDTO);
		Assertions.assertEquals(post.getId(), postDTO.getId());
		Assertions.assertEquals(post.getTitle(), postDTO.getTitle());
		Assertions.assertEquals(post.getContent(), postDTO.getContent());
		Assertions.assertEquals(post.getPostTime(), postDTO.getPostTime());
		Assertions.assertEquals(post.getNewsCategory().getId(), postDTO.getNewsCategory().getId());
		Assertions.assertEquals(post.getNewsCategory().getName(), postDTO.getNewsCategory().getName());
		Assertions.assertEquals(post.getUser().getId(), postDTO.getUser().getId());
		Assertions.assertEquals(post.getUser().getEmail(), postDTO.getUser().getEmail());
		Assertions.assertEquals(post.getUser().getFullName(), postDTO.getUser().getFullName());
		Assertions.assertEquals(post.getUser().getBio(), postDTO.getUser().getBio());
		Assertions.assertEquals(post.getUser().getBirthdate(), postDTO.getUser().getBirthdate());
		Assertions.assertEquals(post.getUser().getDeleteApplication(), postDTO.getUser().getDeleteApplication());


	}


	@Test
	void testToPostModel() {
		UserDTO userDTO = new UserDTO();
		userDTO.setId(5L);
		userDTO.setFullName("Ali");
		userDTO.setEmail("ali@gamil.com");
		userDTO.setBio("My name is Ali");
		userDTO.setBirthdate("2023-07-13");
		userDTO.setDeleteApplication(false);

		NewsCategoryDTO newsCategoryDTO  = new NewsCategoryDTO();
		newsCategoryDTO.setId(1L);
		newsCategoryDTO.setName("Sport");

		PostDTO postDTO = new PostDTO();
		postDTO.setId(1L);
		postDTO.setTitle("Test Post");
		postDTO.setContent("This is a test post content");
		postDTO.setPostTime("2023-08-08 15:42:14");
		postDTO.setUser(userDTO);
		postDTO.setNewsCategory(newsCategoryDTO);

		Post post = postMapper.toPostModel(postDTO);

		Assertions.assertNotNull(post);
		Assertions.assertEquals(postDTO.getId(), post.getId());
		Assertions.assertEquals(postDTO.getTitle(), post.getTitle());
		Assertions.assertEquals(postDTO.getContent(), post.getContent());
		Assertions.assertEquals(postDTO.getPostTime(), post.getPostTime());
		Assertions.assertEquals(postDTO.getNewsCategory().getId(), post.getNewsCategory().getId());
		Assertions.assertEquals(postDTO.getNewsCategory().getName(), post.getNewsCategory().getName());
		Assertions.assertEquals(postDTO.getUser().getId(), post.getUser().getId());
		Assertions.assertEquals(postDTO.getUser().getEmail(), post.getUser().getEmail());
		Assertions.assertEquals(postDTO.getUser().getFullName(), post.getUser().getFullName());
		Assertions.assertEquals(postDTO.getUser().getBio(), post.getUser().getBio());
		Assertions.assertEquals(postDTO.getUser().getBirthdate(), post.getUser().getBirthdate());
		Assertions.assertEquals(postDTO.getUser().getDeleteApplication(), post.getUser().getDeleteApplication());


	}


	@Test
	void testToPostDtoList() {

		User user = new User();
		user.setId(5L);
		user.setFullName("Ali");
		user.setEmail("ali@gamil.com");
		user.setBio("My name is Ali");
		user.setBirthdate("2023-07-13");
		user.setDeleteApplication(false);

		NewsCategory newsCategory  = new NewsCategory();
		newsCategory.setId(1L);
		newsCategory.setName("Sport");

		Post post1 = new Post();
		post1.setId(1L);
		post1.setTitle("Test Post");
		post1.setContent("This is a test post content");
		post1.setPostTime("2023-08-08 15:42:14");
		post1.setUser(user);
		post1.setNewsCategory(newsCategory);

		Post post2 = new Post();
		post2.setId(2L);
		post2.setTitle("Test Post 2");
		post2.setContent("This is a test post content 2");
		post2.setPostTime("2023-08-08 15:88:15");
		post2.setUser(user);
		post2.setNewsCategory(newsCategory);

		List<Post> postList = new ArrayList<>();
		postList.add(post1);
		postList.add(post2);

		List<PostDTO> postDTOList = postMapper.toPostDtoList(postList);


		Assertions.assertNotNull(postDTOList);
		Assertions.assertEquals(postDTOList.size(),  2);

		Assertions.assertEquals(post1.getId(), postDTOList.get(0).getId());
		Assertions.assertEquals(post1.getTitle(), postDTOList.get(0).getTitle());
		Assertions.assertEquals(post1.getContent(), postDTOList.get(0).getContent());
		Assertions.assertEquals(post1.getPostTime(), postDTOList.get(0).getPostTime());
		Assertions.assertEquals(post1.getNewsCategory().getId(), postDTOList.get(0).getNewsCategory().getId());
		Assertions.assertEquals(post1.getNewsCategory().getName(), postDTOList.get(0).getNewsCategory().getName());
		Assertions.assertEquals(post1.getUser().getId(), postDTOList.get(0).getUser().getId());
		Assertions.assertEquals(post1.getUser().getEmail(), postDTOList.get(0).getUser().getEmail());
		Assertions.assertEquals(post1.getUser().getFullName(), postList.get(0).getUser().getFullName());
		Assertions.assertEquals(post1.getUser().getBio(), postDTOList.get(0).getUser().getBio());
		Assertions.assertEquals(post1.getUser().getBirthdate(), postDTOList.get(0).getUser().getBirthdate());
		Assertions.assertEquals(post1.getUser().getDeleteApplication(),
				postDTOList.get(0).getUser().getDeleteApplication());


		Assertions.assertEquals(post2.getId(), postDTOList.get(1).getId());
		Assertions.assertEquals(post2.getTitle(), postDTOList.get(1).getTitle());
		Assertions.assertEquals(post2.getContent(), postDTOList.get(1).getContent());
		Assertions.assertEquals(post2.getPostTime(), postDTOList.get(1).getPostTime());
		Assertions.assertEquals(post2.getNewsCategory().getId(), postDTOList.get(1).getNewsCategory().getId());
		Assertions.assertEquals(post2.getNewsCategory().getName(), postDTOList.get(1).getNewsCategory().getName());
		Assertions.assertEquals(post2.getUser().getId(), postDTOList.get(1).getUser().getId());
		Assertions.assertEquals(post2.getUser().getEmail(), postDTOList.get(1).getUser().getEmail());
		Assertions.assertEquals(post2.getUser().getFullName(), postList.get(1).getUser().getFullName());
		Assertions.assertEquals(post2.getUser().getBio(), postDTOList.get(1).getUser().getBio());
		Assertions.assertEquals(post2.getUser().getBirthdate(), postDTOList.get(1).getUser().getBirthdate());
		Assertions.assertEquals(post2.getUser().getDeleteApplication(),
				postDTOList.get(1).getUser().getDeleteApplication());
	}

    @Test
	void testToPostModalList() {

		UserDTO userDTO = new UserDTO();
		userDTO.setId(5L);
		userDTO.setFullName("Ali");
		userDTO.setEmail("ali@gamil.com");
		userDTO.setBio("My name is Ali");
		userDTO.setBirthdate("2023-07-13");
		userDTO.setDeleteApplication(false);

		NewsCategoryDTO newsCategoryDTO  = new NewsCategoryDTO();
		newsCategoryDTO.setId(1L);
		newsCategoryDTO.setName("Sport");

		PostDTO postDTO1 = new PostDTO();
		postDTO1.setId(1L);
		postDTO1.setTitle("Test Post");
		postDTO1.setContent("This is a test post content");
		postDTO1.setPostTime("2023-08-08 15:42:14");
		postDTO1.setUser(userDTO);
		postDTO1.setNewsCategory(newsCategoryDTO);

		PostDTO postDTO2 = new PostDTO();
		postDTO2.setId(2L);
		postDTO2.setTitle("Test Post 2");
		postDTO2.setContent("This is a test post content 2");
		postDTO2.setPostTime("2023-08-08 15:88:15");
		postDTO2.setUser(userDTO);
		postDTO2.setNewsCategory(newsCategoryDTO);

		List<PostDTO> postDTOList = new ArrayList<>();
		postDTOList.add(postDTO1);
		postDTOList.add(postDTO2);

		List<Post> postList = postMapper.toPostModellist(postDTOList);


		Assertions.assertNotNull(postList);
		Assertions.assertEquals(postList.size(),  2);

		Assertions.assertEquals(postDTO1.getId(), postList.get(0).getId());
		Assertions.assertEquals(postDTO1.getTitle(), postList.get(0).getTitle());
		Assertions.assertEquals(postDTO1.getContent(), postList.get(0).getContent());
		Assertions.assertEquals(postDTO1.getPostTime(), postList.get(0).getPostTime());
		Assertions.assertEquals(postDTO1.getNewsCategory().getId(), postList.get(0).getNewsCategory().getId());
		Assertions.assertEquals(postDTO1.getNewsCategory().getName(), postList.get(0).getNewsCategory().getName());
		Assertions.assertEquals(postDTO1.getUser().getId(), postList.get(0).getUser().getId());
		Assertions.assertEquals(postDTO1.getUser().getEmail(), postList.get(0).getUser().getEmail());
		Assertions.assertEquals(postDTO1.getUser().getFullName(), postList.get(0).getUser().getFullName());
		Assertions.assertEquals(postDTO1.getUser().getBio(), postList.get(0).getUser().getBio());
		Assertions.assertEquals(postDTO1.getUser().getBirthdate(), postList.get(0).getUser().getBirthdate());
		Assertions.assertEquals(postDTO1.getUser().getDeleteApplication(),
				postList.get(0).getUser().getDeleteApplication());


		Assertions.assertEquals(postDTO2.getId(), postList.get(1).getId());
		Assertions.assertEquals(postDTO2.getTitle(), postList.get(1).getTitle());
		Assertions.assertEquals(postDTO2.getContent(), postList.get(1).getContent());
		Assertions.assertEquals(postDTO2.getPostTime(), postList.get(1).getPostTime());
		Assertions.assertEquals(postDTO2.getNewsCategory().getId(), postList.get(1).getNewsCategory().getId());
		Assertions.assertEquals(postDTO2.getNewsCategory().getName(), postList.get(1).getNewsCategory().getName());
		Assertions.assertEquals(postDTO2.getUser().getId(), postList.get(1).getUser().getId());
		Assertions.assertEquals(postDTO2.getUser().getEmail(), postList.get(1).getUser().getEmail());
		Assertions.assertEquals(postDTO2.getUser().getFullName(), postList.get(1).getUser().getFullName());
		Assertions.assertEquals(postDTO2.getUser().getBio(), postList.get(1).getUser().getBio());
		Assertions.assertEquals(postDTO2.getUser().getBirthdate(), postList.get(1).getUser().getBirthdate());
		Assertions.assertEquals(postDTO2.getUser().getDeleteApplication(),
				postList.get(1).getUser().getDeleteApplication());


	}

	@Test
	void testAddPost() {

		User user = new User();
		user.setFullName("Ali");
		UserDTO userDTO = userMapper.toUserDto(userRepository.save(user));

		NewsCategory newsCategory = new NewsCategory();
		newsCategory.setName("sport");
		NewsCategoryDTO newsCategoryDTO = newsCategoryMapper
				.toNewsCategoryDto(newsCategoryRepository.save(newsCategory));

		PostDTO postDTO1 = new PostDTO();
		postDTO1.setTitle("Test Post");
		postDTO1.setContent("This is a test post content");
		postDTO1.setUser(userDTO);
		postDTO1.setNewsCategory(newsCategoryDTO);

		PostDTO newPostDTO = postService.addPost(postDTO1);

		Assertions.assertNotNull(newPostDTO);
		Assertions.assertNotNull(newPostDTO.getPostTime());
		Assertions.assertNotNull(newPostDTO.getId());
		Assertions.assertEquals(postDTO1.getTitle(), newPostDTO.getTitle());
		Assertions.assertEquals(postDTO1.getContent(), newPostDTO.getContent());
		Assertions.assertEquals(postDTO1.getUser().getId(), newPostDTO.getUser().getId());
		Assertions.assertEquals(postDTO1.getNewsCategory().getId(), newPostDTO.getNewsCategory().getId());

		postRepository.deleteAll();
		newsCategoryRepository.deleteAll();
		userRepository.deleteAll();

	}

	@Test
	void testGetPost(){

		User user = new User();
		UserDTO userDTO = userMapper.toUserDto(userRepository.save(user));

		NewsCategory newsCategory = new NewsCategory();
		NewsCategoryDTO newsCategoryDTO = newsCategoryMapper
				.toNewsCategoryDto(newsCategoryRepository.save(newsCategory));

		PostDTO postDTO1 = new PostDTO();
		postDTO1.setTitle("Test Post");
		postDTO1.setContent("This is a test post content");
		postDTO1.setUser(userDTO);
		postDTO1.setNewsCategory(newsCategoryDTO);

		PostDTO newPostDTO = postService.addPost(postDTO1);

		PostDTO correctPostDTO = postService.getPost(newPostDTO.getId());

		Assertions.assertNotNull(correctPostDTO);
		Assertions.assertNotNull(correctPostDTO.getId());
		Assertions.assertNotNull(correctPostDTO.getPostTime());
		Assertions.assertEquals(postDTO1.getTitle(), correctPostDTO.getTitle());
		Assertions.assertEquals(postDTO1.getContent(), correctPostDTO.getContent());
		Assertions.assertEquals(postDTO1.getUser().getId(), correctPostDTO.getUser().getId());
		Assertions.assertEquals(postDTO1.getNewsCategory().getId(), correctPostDTO.getNewsCategory().getId());

		postRepository.deleteAll();
		newsCategoryRepository.deleteAll();
		userRepository.deleteAll();

	}


    @Test
    void testUpdatePost() {

        User user = new User();
        UserDTO userDTO = userMapper.toUserDto(userRepository.save(user));

        NewsCategory newsCategory = new NewsCategory();
        NewsCategoryDTO newsCategoryDTO = newsCategoryMapper
                .toNewsCategoryDto(newsCategoryRepository.save(newsCategory));

        NewsCategory updateNewsCategory = new NewsCategory();
        NewsCategoryDTO updateNewsCategoryDTO = newsCategoryMapper
                .toNewsCategoryDto(newsCategoryRepository.save(updateNewsCategory));


        PostDTO postDTO1 = new PostDTO();
        postDTO1.setTitle("Test Post");
        postDTO1.setContent("This is a test post content");
        postDTO1.setUser(userDTO);
        postDTO1.setNewsCategory(newsCategoryDTO);

        PostDTO newPostDTO = postService.addPost(postDTO1);

        newPostDTO.setTitle("Update Post");
        newPostDTO.setContent("This is a update post content");
        newPostDTO.setNewsCategory(updateNewsCategoryDTO);

        PostDTO updatePostDTO = postService.updatePost(newPostDTO);

        Assertions.assertNotNull(updatePostDTO);
        Assertions.assertNotNull(updatePostDTO.getId());
        Assertions.assertNotNull(updatePostDTO.getPostTime());
        Assertions.assertEquals("Update Post", updatePostDTO.getTitle());
        Assertions.assertEquals("This is a update post content", updatePostDTO.getContent());
        Assertions.assertEquals(newPostDTO.getUser().getId(), updatePostDTO.getUser().getId());
        Assertions.assertEquals(updateNewsCategoryDTO.getId(), updatePostDTO.getNewsCategory().getId());

        postRepository.deleteAll();
        newsCategoryRepository.deleteAll();
        userRepository.deleteAll();

    }

    @Test
    void testDeletePost() {

        PostDTO postDTO1 = new PostDTO();
        postDTO1.setTitle("Test Post");
        postDTO1.setContent("This is a test post content");

        PostDTO newPostDTO = postService.addPost(postDTO1);

        Assertions.assertNotNull(newPostDTO);

        postService.deletePost(newPostDTO.getId());

       Assertions.assertFalse(postRepository.existsById(newPostDTO.getId()));

    }

    @Test
    void testGetAllPosts(){

        User user = new User();
        UserDTO userDTO = userMapper.toUserDto(userRepository.save(user));

        NewsCategory newsCategory = new NewsCategory();
        NewsCategoryDTO newsCategoryDTO = newsCategoryMapper
                .toNewsCategoryDto(newsCategoryRepository.save(newsCategory));

        PostDTO postDTO1 = new PostDTO();
        postDTO1.setTitle("Test Post 1");
        postDTO1.setContent("This is a test post content number 1");
        postDTO1.setUser(userDTO);
        postDTO1.setNewsCategory(newsCategoryDTO);

        PostDTO newPostDTO1 = postService.addPost(postDTO1);

        PostDTO postDTO2 = new PostDTO();
        postDTO2.setTitle("Test Post 2");
        postDTO2.setContent("This is a test post content number 2");
        postDTO2.setUser(userDTO);
        postDTO2.setNewsCategory(newsCategoryDTO);

        PostDTO newPostDTO2 = postService.addPost(postDTO2);

        List<PostDTO> postDTOList = postService.getAllLastPosts();

        Assertions.assertNotNull(postDTOList);
        Assertions.assertEquals(newPostDTO1.getId() , postDTOList.get(0).getId());
        Assertions.assertEquals(newPostDTO1.getPostTime() , postDTOList.get(0).getPostTime());
        Assertions.assertEquals("Test Post 1", postDTOList.get(0).getTitle());
        Assertions.assertEquals("This is a test post content number 1" , postDTOList.get(0).getContent());
        Assertions.assertEquals(newPostDTO1.getUser().getId() , postDTOList.get(0).getUser().getId());
        Assertions.assertEquals(newPostDTO1.getNewsCategory().getId() , postDTOList.get(0).getNewsCategory().getId());

        Assertions.assertEquals(newPostDTO2.getId() , postDTOList.get(1).getId());
        Assertions.assertEquals(newPostDTO2.getPostTime() , postDTOList.get(1).getPostTime());
        Assertions.assertEquals("Test Post 2", postDTOList.get(1).getTitle());
        Assertions.assertEquals("This is a test post content number 2" , postDTOList.get(1).getContent());
        Assertions.assertEquals(newPostDTO2.getUser().getId() , postDTOList.get(1).getUser().getId());
        Assertions.assertEquals(newPostDTO2.getNewsCategory().getId() , postDTOList.get(1).getNewsCategory().getId());


        postRepository.deleteAll();
        newsCategoryRepository.deleteAll();
        userRepository.deleteAll();

    }

    @Test
    void testGetPostsByUserId(){

        User user1 = new User();
        UserDTO userDTO1 = userMapper.toUserDto(userRepository.save(user1));

        User user2 = new User();
        UserDTO userDTO2 = userMapper.toUserDto(userRepository.save(user2));

        NewsCategory newsCategory = new NewsCategory();
        NewsCategoryDTO newsCategoryDTO = newsCategoryMapper
                .toNewsCategoryDto(newsCategoryRepository.save(newsCategory));

        PostDTO postDTO1 = new PostDTO();
        postDTO1.setTitle("Test Post 1");
        postDTO1.setContent("This is a test post content number 1");
        postDTO1.setUser(userDTO1);
        postDTO1.setNewsCategory(newsCategoryDTO);

        PostDTO newPostDTO1 = postService.addPost(postDTO1);

        Assertions.assertNotNull(newPostDTO1);

        PostDTO postDTO2 = new PostDTO();
        postDTO2.setTitle("Test Post 2");
        postDTO2.setContent("This is a test post content number 2");
        postDTO2.setUser(userDTO2);
        postDTO2.setNewsCategory(newsCategoryDTO);

        PostDTO newPostDTO2 = postService.addPost(postDTO2);

        Assertions.assertNotNull(newPostDTO2);

        List<PostDTO> postDTOList = postService.getPostsByUserId(userDTO1.getId());

        Assertions.assertNotNull(postDTOList);
        Assertions.assertEquals(1, postDTOList.size());
        Assertions.assertEquals(newPostDTO1.getId() , postDTOList.get(0).getId());
        Assertions.assertEquals(newPostDTO1.getPostTime() , postDTOList.get(0).getPostTime());
        Assertions.assertEquals("Test Post 1", postDTOList.get(0).getTitle());
        Assertions.assertEquals("This is a test post content number 1" , postDTOList.get(0).getContent());
        Assertions.assertEquals(userDTO1.getId() , postDTOList.get(0).getUser().getId());
        Assertions.assertEquals(newPostDTO1.getNewsCategory().getId() , postDTOList.get(0).getNewsCategory().getId());


        postRepository.deleteAll();
        newsCategoryRepository.deleteAll();
        userRepository.deleteAll();

    }

    @Test
    void testGetPostsByNewsCategory(){

        User user = new User();
        UserDTO userDTO = userMapper.toUserDto(userRepository.save(user));

        NewsCategory newsCategory1 = new NewsCategory();
        newsCategory1.setName("sport");
        NewsCategoryDTO newsCategoryDTO1 = newsCategoryMapper
                .toNewsCategoryDto(newsCategoryRepository.save(newsCategory1));

        NewsCategory newsCategory2 = new NewsCategory();
        newsCategory1.setName("media");
        NewsCategoryDTO newsCategoryDTO2 = newsCategoryMapper
                .toNewsCategoryDto(newsCategoryRepository.save(newsCategory2));

        PostDTO postDTO1 = new PostDTO();
        postDTO1.setTitle("Test Post 1");
        postDTO1.setContent("This is a test post content number 1");
        postDTO1.setUser(userDTO);
        postDTO1.setNewsCategory(newsCategoryDTO1);

        PostDTO newPostDTO1 = postService.addPost(postDTO1);
        Assertions.assertNotNull(newPostDTO1);

        PostDTO postDTO2 = new PostDTO();
        postDTO2.setTitle("Test Post 2");
        postDTO2.setContent("This is a test post content number 2");
        postDTO2.setUser(userDTO);
        postDTO2.setNewsCategory(newsCategoryDTO2);

        PostDTO newPostDTO2 = postService.addPost(postDTO2);

        Assertions.assertNotNull(newPostDTO2);

        List<PostDTO> postDTOList = postService.getPostsByNewsCategory("sport");

        Assertions.assertNotNull(postDTOList);
        Assertions.assertEquals(1, postDTOList.size());
        Assertions.assertEquals(newPostDTO1.getId() , postDTOList.get(0).getId());
        Assertions.assertEquals(newPostDTO1.getPostTime() , postDTOList.get(0).getPostTime());
        Assertions.assertEquals("Test Post 1", postDTOList.get(0).getTitle());
        Assertions.assertEquals("This is a test post content number 1" , postDTOList.get(0).getContent());
        Assertions.assertEquals(newPostDTO1.getUser().getId() , postDTOList.get(0).getUser().getId());
        Assertions.assertEquals(newsCategoryDTO1.getId() , postDTOList.get(0).getNewsCategory().getId());
        Assertions.assertEquals("sport" , postDTOList.get(0).getNewsCategory().getName());


        postRepository.deleteAll();
        newsCategoryRepository.deleteAll();
        userRepository.deleteAll();

    }

	@Test
	void testToCommentDto() {

		User user = new User();
		user.setId(5L);
		user.setFullName("Ali");
		user.setEmail("ali@gamil.com");
		user.setBio("My name is Ali");
		user.setBirthdate("2023-07-13");
		user.setDeleteApplication(false);


		Post post = new Post();
		post.setId(1L);
		post.setTitle("Test Post");
		post.setContent("This is a test post content");
		post.setPostTime("2023-08-08 15:42:14");

		Comment comment = new Comment();
		comment.setId(1L);
		comment.setComment("Comment for test");
		comment.setCommentTime("2025-08-08 01:42:15");
		comment.setUser(user);
		comment.setPost(post);

		CommentDTO commentDTO = commentMapper.toCommentDto(comment);

		Assertions.assertNotNull(commentDTO);
		Assertions.assertEquals(comment.getId(), commentDTO.getId());
		Assertions.assertEquals(comment.getComment(), commentDTO.getComment());
		Assertions.assertEquals(comment.getCommentTime(), commentDTO.getCommentTime());
		Assertions.assertEquals(comment.getUser().getId(), commentDTO.getUser().getId());
		Assertions.assertEquals(comment.getUser().getEmail(), commentDTO.getUser().getEmail());
		Assertions.assertEquals(comment.getUser().getFullName(), commentDTO.getUser().getFullName());
		Assertions.assertEquals(comment.getUser().getBio(), commentDTO.getUser().getBio());
		Assertions.assertEquals(comment.getUser().getBirthdate(), commentDTO.getUser().getBirthdate());
		Assertions.assertEquals(comment.getUser().getDeleteApplication(), commentDTO.getUser().getDeleteApplication());
		Assertions.assertEquals(comment.getPost().getId(), commentDTO.getPost().getId());
		Assertions.assertEquals(comment.getPost().getTitle(), commentDTO.getPost().getTitle());
		Assertions.assertEquals(comment.getPost().getContent(), commentDTO.getPost().getContent());
		Assertions.assertEquals(comment.getPost().getPostTime(), commentDTO.getPost().getPostTime());


	}

	@Test
	void testToCommentModel() {

		UserDTO userDTO = new UserDTO();
		userDTO.setId(5L);
		userDTO.setFullName("Ali");
		userDTO.setEmail("ali@gamil.com");
		userDTO.setBio("My name is Ali");
		userDTO.setBirthdate("2023-07-13");
		userDTO.setDeleteApplication(false);


		PostDTO postDTO = new PostDTO();
		postDTO.setId(1L);
		postDTO.setTitle("Test Post");
		postDTO.setContent("This is a test post content");
		postDTO.setPostTime("2023-08-08 15:42:14");

		CommentDTO commentDTO = new CommentDTO();
		commentDTO.setId(1L);
		commentDTO.setComment("Comment for test");
		commentDTO.setCommentTime("2025-08-08 01:42:15");
		commentDTO.setUser(userDTO);
		commentDTO.setPost(postDTO);

		Comment comment = commentMapper.toCommentModel(commentDTO);

		Assertions.assertNotNull(comment);
		Assertions.assertEquals(comment.getId(), commentDTO.getId());
		Assertions.assertEquals(comment.getComment(), commentDTO.getComment());
		Assertions.assertEquals(comment.getCommentTime(), commentDTO.getCommentTime());
		Assertions.assertEquals(comment.getUser().getId(), commentDTO.getUser().getId());
		Assertions.assertEquals(comment.getUser().getEmail(), commentDTO.getUser().getEmail());
		Assertions.assertEquals(comment.getUser().getFullName(), commentDTO.getUser().getFullName());
		Assertions.assertEquals(comment.getUser().getBio(), commentDTO.getUser().getBio());
		Assertions.assertEquals(comment.getUser().getBirthdate(), commentDTO.getUser().getBirthdate());
		Assertions.assertEquals(comment.getUser().getDeleteApplication(), commentDTO.getUser().getDeleteApplication());
		Assertions.assertEquals(comment.getPost().getId(), commentDTO.getPost().getId());
		Assertions.assertEquals(comment.getPost().getTitle(), commentDTO.getPost().getTitle());
		Assertions.assertEquals(comment.getPost().getContent(), commentDTO.getPost().getContent());
		Assertions.assertEquals(comment.getPost().getPostTime(), commentDTO.getPost().getPostTime());


	}

	@Test
	void testToCommentDtoList() {

		User user = new User();
		user.setId(5L);
		user.setFullName("Ali");
		user.setEmail("ali@gamil.com");
		user.setBio("My name is Ali");
		user.setBirthdate("2023-07-13");
		user.setDeleteApplication(false);


		Post post = new Post();
		post.setId(1L);
		post.setTitle("Test Post");
		post.setContent("This is a test post content");
		post.setPostTime("2023-08-08 15:42:14");

		Comment comment1 = new Comment();
		comment1.setId(1L);
		comment1.setComment("Comment for test nember 1");
		comment1.setCommentTime("1995-08-08 01:42:15");
		comment1.setUser(user);
		comment1.setPost(post);

		Comment comment2 = new Comment();
		comment2.setId(2L);
		comment2.setComment("Comment for test number 2");
		comment2.setCommentTime("2025-10-08 01:42:15");
		comment2.setUser(user);
		comment2.setPost(post);

		List<Comment>  commentList = new ArrayList<>();
		commentList.add(comment1);
		commentList.add(comment2);

		List<CommentDTO> commentDTOList = commentMapper.toCommentDtoList(commentList);

		Assertions.assertNotNull(commentDTOList);
		Assertions.assertEquals(comment1.getId(), commentDTOList.get(0).getId());
		Assertions.assertEquals(comment1.getComment(), commentDTOList.get(0).getComment());
		Assertions.assertEquals(comment1.getCommentTime(), commentDTOList.get(0).getCommentTime());
		Assertions.assertEquals(comment1.getUser().getId(), commentDTOList.get(0).getUser().getId());
		Assertions.assertEquals(comment1.getUser().getEmail(), commentDTOList.get(0).getUser().getEmail());
		Assertions.assertEquals(comment1.getUser().getFullName(), commentDTOList.get(0).getUser().getFullName());
		Assertions.assertEquals(comment1.getUser().getBio(), commentDTOList.get(0).getUser().getBio());
		Assertions.assertEquals(comment1.getUser().getBirthdate(), commentDTOList.get(0).getUser().getBirthdate());
		Assertions.assertEquals(comment1.getUser().getDeleteApplication(),
				commentDTOList.get(0).getUser().getDeleteApplication());
		Assertions.assertEquals(comment1.getPost().getId(), commentDTOList.get(0).getPost().getId());
		Assertions.assertEquals(comment1.getPost().getTitle(), commentDTOList.get(0).getPost().getTitle());
		Assertions.assertEquals(comment1.getPost().getContent(), commentDTOList.get(0).getPost().getContent());
		Assertions.assertEquals(comment1.getPost().getPostTime(), commentDTOList.get(0).getPost().getPostTime());

		Assertions.assertEquals(comment2.getId(), commentDTOList.get(1).getId());
		Assertions.assertEquals(comment2.getComment(), commentDTOList.get(1).getComment());
		Assertions.assertEquals(comment2.getCommentTime(), commentDTOList.get(1).getCommentTime());
		Assertions.assertEquals(comment2.getUser().getId(), commentDTOList.get(1).getUser().getId());
		Assertions.assertEquals(comment2.getUser().getEmail(), commentDTOList.get(1).getUser().getEmail());
		Assertions.assertEquals(comment2.getUser().getFullName(), commentDTOList.get(1).getUser().getFullName());
		Assertions.assertEquals(comment2.getUser().getBio(), commentDTOList.get(1).getUser().getBio());
		Assertions.assertEquals(comment2.getUser().getBirthdate(), commentDTOList.get(1).getUser().getBirthdate());
		Assertions.assertEquals(comment2.getUser().getDeleteApplication(),
				commentDTOList.get(1).getUser().getDeleteApplication());
		Assertions.assertEquals(comment2.getPost().getId(), commentDTOList.get(1).getPost().getId());
		Assertions.assertEquals(comment2.getPost().getTitle(), commentDTOList.get(1).getPost().getTitle());
		Assertions.assertEquals(comment2.getPost().getContent(), commentDTOList.get(1).getPost().getContent());
		Assertions.assertEquals(comment2.getPost().getPostTime(), commentDTOList.get(1).getPost().getPostTime());


	}

	@Test
	void testToCommentModelList() {

		UserDTO userDTO = new UserDTO();
		userDTO.setId(5L);
		userDTO.setFullName("Ali");
		userDTO.setEmail("ali@gamil.com");
		userDTO.setBio("My name is Ali");
		userDTO.setBirthdate("2023-07-13");
		userDTO.setDeleteApplication(false);


		PostDTO postDTO = new PostDTO();
		postDTO.setId(1L);
		postDTO.setTitle("Test Post");
		postDTO.setContent("This is a test post content");
		postDTO.setPostTime("2023-08-08 15:42:14");

		CommentDTO commentDTO1 = new CommentDTO();
		commentDTO1.setId(1L);
		commentDTO1.setComment("Comment for test number 1");
		commentDTO1.setCommentTime("1999-08-08 01:42:15");
		commentDTO1.setUser(userDTO);
		commentDTO1.setPost(postDTO);

		CommentDTO commentDTO2 = new CommentDTO();
		commentDTO2.setId(2L);
		commentDTO2.setComment("Comment for test number 2");
		commentDTO2.setCommentTime("2025-08-08 01:42:15");
		commentDTO2.setUser(userDTO);
		commentDTO2.setPost(postDTO);

		List<CommentDTO>  commentDTOList = new ArrayList<>();
		commentDTOList.add(commentDTO1);
		commentDTOList.add(commentDTO2);

		List<Comment> commentList = commentMapper.toCommetModelList(commentDTOList);

		Assertions.assertNotNull(commentList);
		Assertions.assertEquals(commentDTO1.getId(), commentList.get(0).getId());
		Assertions.assertEquals(commentDTO1.getComment(), commentList.get(0).getComment());
		Assertions.assertEquals(commentDTO1.getCommentTime(), commentList.get(0).getCommentTime());
		Assertions.assertEquals(commentDTO1.getUser().getId(), commentList.get(0).getUser().getId());
		Assertions.assertEquals(commentDTO1.getUser().getEmail(), commentList.get(0).getUser().getEmail());
		Assertions.assertEquals(commentDTO1.getUser().getFullName(), commentList.get(0).getUser().getFullName());
		Assertions.assertEquals(commentDTO1.getUser().getBio(), commentList.get(0).getUser().getBio());
		Assertions.assertEquals(commentDTO1.getUser().getBirthdate(), commentList.get(0).getUser().getBirthdate());
		Assertions.assertEquals(commentDTO1.getUser().getDeleteApplication(),
				commentList.get(0).getUser().getDeleteApplication());
		Assertions.assertEquals(commentDTO1.getPost().getId(), commentList.get(0).getPost().getId());
		Assertions.assertEquals(commentDTO1.getPost().getTitle(), commentList.get(0).getPost().getTitle());
		Assertions.assertEquals(commentDTO1.getPost().getContent(), commentList.get(0).getPost().getContent());
		Assertions.assertEquals(commentDTO1.getPost().getPostTime(), commentList.get(0).getPost().getPostTime());

		Assertions.assertEquals(commentDTO2.getId(), commentList.get(1).getId());
		Assertions.assertEquals(commentDTO2.getComment(), commentList.get(1).getComment());
		Assertions.assertEquals(commentDTO2.getCommentTime(), commentList.get(1).getCommentTime());
		Assertions.assertEquals(commentDTO2.getUser().getId(), commentList.get(1).getUser().getId());
		Assertions.assertEquals(commentDTO2.getUser().getEmail(), commentList.get(1).getUser().getEmail());
		Assertions.assertEquals(commentDTO2.getUser().getFullName(), commentList.get(1).getUser().getFullName());
		Assertions.assertEquals(commentDTO2.getUser().getBio(), commentList.get(1).getUser().getBio());
		Assertions.assertEquals(commentDTO2.getUser().getBirthdate(), commentList.get(1).getUser().getBirthdate());
		Assertions.assertEquals(commentDTO2.getUser().getDeleteApplication(),
				commentList.get(1).getUser().getDeleteApplication());
		Assertions.assertEquals(commentDTO2.getPost().getId(), commentList.get(1).getPost().getId());
		Assertions.assertEquals(commentDTO2.getPost().getTitle(), commentList.get(1).getPost().getTitle());
		Assertions.assertEquals(commentDTO2.getPost().getContent(), commentList.get(1).getPost().getContent());
		Assertions.assertEquals(commentDTO2.getPost().getPostTime(), commentList.get(1).getPost().getPostTime());


	}

	@Test
	void testAddComment(){

		User user = new User();
		User newUser = userRepository.save(user);

		Post post = new Post();
		Post newPost = postRepository.save(post);

		Comment comment  = new Comment();
		comment.setComment("Comment for test");
		comment.setPost(newPost);
		comment.setUser(newUser);

		CommentDTO newCommentDTO = commentService.addComment(commentMapper.toCommentDto(comment));

		Assertions.assertNotNull(newCommentDTO);
		Assertions.assertNotNull(newCommentDTO.getCommentTime());
		Assertions.assertEquals("Comment for test",newCommentDTO.getComment());
		Assertions.assertEquals(newPost.getId(),newCommentDTO.getPost().getId());
		Assertions.assertEquals(newUser.getId(), newCommentDTO.getUser().getId());

		commentRepository.deleteAll();
		postRepository.deleteAll();
		userRepository.deleteAll();

	}

	@Test
	void testGetComments(){

		User user = new User();
		User newUser = userRepository.save(user);

		Post post1 = new Post();
		Post newPost1 = postRepository.save(post1);

		Post post2 = new Post();
		Post newPost2 = postRepository.save(post2);

		Comment comment1  = new Comment();
		comment1.setComment("Comment for test number 1");
		comment1.setPost(newPost1);
		comment1.setUser(newUser);

		Comment comment2  = new Comment();
		comment2.setComment("Comment for test number 2");
		comment2.setPost(newPost2);
		comment2.setUser(newUser);

		CommentDTO newCommentDTO1 = commentService.addComment(commentMapper.toCommentDto(comment1));
		CommentDTO newCommentDTO2 = commentService.addComment(commentMapper.toCommentDto(comment2));

		Assertions.assertNotNull(newCommentDTO1);
		Assertions.assertNotNull(newCommentDTO2);

		List<CommentDTO> commentDTOList = commentService.getComments(newPost1.getId());

		Assertions.assertNotNull(commentDTOList);
		Assertions.assertEquals(1, commentDTOList.size());
		Assertions.assertEquals(newCommentDTO1.getId(), commentDTOList.get(0).getId());
		Assertions.assertEquals(newCommentDTO1.getCommentTime(),commentDTOList.get(0).getCommentTime());
		Assertions.assertEquals("Comment for test number 1",commentDTOList.get(0).getComment());
		Assertions.assertEquals(newPost1.getId(),commentDTOList.get(0).getPost().getId());
		Assertions.assertEquals(newUser.getId(), commentDTOList.get(0).getUser().getId());

		commentRepository.deleteAll();
		postRepository.deleteAll();
		userRepository.deleteAll();


	}

	@Test
	void testDeleteComment(){

		Comment comment  = new Comment();
		comment.setComment("Comment for test");

		CommentDTO newCommentDTO = commentService.addComment(commentMapper.toCommentDto(comment));

		Assertions.assertNotNull(newCommentDTO);

		commentService.deleteComment(newCommentDTO.getId());

		Assertions.assertFalse(commentRepository.existsById(newCommentDTO.getId()));

	}

	@Test
	void  testToPermissionDto(){

		Permission permission = new Permission();
		permission.setId(1L);
		permission.setRole("ADMIN");

		PermissionDTO  permissionDTO = permissionMapper.toPermissionDto(permission);

		Assertions.assertNotNull(permissionDTO);
		Assertions.assertEquals(1L,permissionDTO.getId());
		Assertions.assertEquals("ADMIN", permissionDTO.getRole());

	}

	@Test
	void  testToPermissionModel(){

		PermissionDTO permissionDTO = new PermissionDTO();
		permissionDTO.setId(1L);
		permissionDTO.setRole("ADMIN");

		Permission permission = permissionMapper.toPermissionModel(permissionDTO);

		Assertions.assertNotNull(permission);
		Assertions.assertEquals(1L,permission.getId());
		Assertions.assertEquals("ADMIN", permission.getRole());

	}

	@Test
	void  testToPermissionDtoList(){

		Permission permission1 = new Permission();
		permission1.setId(1L);
		permission1.setRole("ADMIN");

		Permission permission2 = new Permission();
		permission2.setId(2L);
		permission2.setRole("USER");

		List<Permission> permissionList = new ArrayList<>();
		permissionList.add(permission1);
		permissionList.add(permission2);

		List<PermissionDTO> permissionDTOList = permissionMapper.toPermissionDtoList(permissionList);

		Assertions.assertNotNull(permissionDTOList);
		Assertions.assertEquals(1L,permissionDTOList.get(0).getId());
		Assertions.assertEquals("ADMIN", permissionDTOList.get(0).getRole());
		Assertions.assertEquals(2L,permissionDTOList.get(1).getId());
		Assertions.assertEquals("USER", permissionDTOList.get(1).getRole());


	}

	@Test
	void  testToPermissionModelList(){

		PermissionDTO permissionDTO1 = new PermissionDTO();
		permissionDTO1.setId(1L);
		permissionDTO1.setRole("ADMIN");

		PermissionDTO permissionDTO2 = new PermissionDTO();
		permissionDTO2.setId(2L);
		permissionDTO2.setRole("USER");

		List<PermissionDTO> permissionDTOList = new ArrayList<>();
		permissionDTOList.add(permissionDTO1);
		permissionDTOList.add(permissionDTO2);

		List<Permission> permissionList = permissionMapper.toPermissionModelList(permissionDTOList);

		Assertions.assertNotNull(permissionList);
		Assertions.assertEquals(1L,permissionList.get(0).getId());
		Assertions.assertEquals("ADMIN", permissionList.get(0).getRole());
		Assertions.assertEquals(2L,permissionList.get(1).getId());
		Assertions.assertEquals("USER", permissionList.get(1).getRole());


	}


	@Test
	void  testGetAllPermissions(){

		Permission permission1 = new Permission();
		permission1.setRole("ADMIN");

		Permission permission2 = new Permission();
		permission2.setRole("USER");

		permissionRepository.save(permission1);
		permissionRepository.save(permission2);


		List<PermissionDTO> permissionDTOList = permissionService.getAllPermissions();

		Assertions.assertNotNull(permissionDTOList);
		Assertions.assertEquals(2, permissionDTOList.size());
		Assertions.assertNotNull(permissionDTOList.get(0).getId());
		Assertions.assertEquals("ADMIN", permissionDTOList.get(0).getRole());
		Assertions.assertNotNull(permissionDTOList.get(1).getId());
		Assertions.assertEquals("USER", permissionDTOList.get(1).getRole());


	}

	@Test
	void  testToNewsCategoryDto() {

		NewsCategory newsCategory = new NewsCategory();
		newsCategory.setId(1L);
		newsCategory.setName("sport");

		NewsCategoryDTO newsCategoryDTO = newsCategoryMapper.toNewsCategoryDto(newsCategory);

		Assertions.assertNotNull(newsCategoryDTO);
		Assertions.assertEquals(1L, newsCategoryDTO.getId());
		Assertions.assertEquals("sport", newsCategoryDTO.getName());

	}

	@Test
	void  testToNewsCategoryModel() {

		NewsCategoryDTO newsCategoryDTO = new NewsCategoryDTO();
		newsCategoryDTO.setId(1L);
		newsCategoryDTO.setName("sport");

		NewsCategory newsCategory = newsCategoryMapper.toNewsCategoryModel(newsCategoryDTO);

		Assertions.assertNotNull(newsCategory);
		Assertions.assertEquals(1L, newsCategory.getId());
		Assertions.assertEquals("sport", newsCategory.getName());

	}

	@Test
	void  testToNewsCategoryDtoList() {

		NewsCategory newsCategory1 = new NewsCategory();
		newsCategory1.setId(1L);
		newsCategory1.setName("sport");

		NewsCategory newsCategory2 = new NewsCategory();
		newsCategory2.setId(2L);
		newsCategory2.setName("media");

		List<NewsCategory>  newsCategoryList = new ArrayList<>();
		newsCategoryList.add(newsCategory1);
		newsCategoryList.add(newsCategory2);

		List<NewsCategoryDTO> newsCategoryDTOList = newsCategoryMapper.toNewsCtegoryDtoList(newsCategoryList);

		Assertions.assertNotNull(newsCategoryDTOList);
		Assertions.assertEquals(1L, newsCategoryDTOList.get(0).getId());
		Assertions.assertEquals("sport", newsCategoryDTOList.get(0).getName());
		Assertions.assertEquals(2L, newsCategoryDTOList.get(1).getId());
		Assertions.assertEquals("media", newsCategoryDTOList.get(1).getName());

	}

	@Test
	void  testToNewsCategoryModelList() {

		NewsCategoryDTO newsCategoryDTO1 = new NewsCategoryDTO();
		newsCategoryDTO1.setId(1L);
		newsCategoryDTO1.setName("sport");

		NewsCategoryDTO newsCategoryDTO2 = new NewsCategoryDTO();
		newsCategoryDTO2.setId(2L);
		newsCategoryDTO2.setName("media");

		List<NewsCategoryDTO>  newsCategoryDTOList = new ArrayList<>();
		newsCategoryDTOList.add(newsCategoryDTO1);
		newsCategoryDTOList.add(newsCategoryDTO2);

		List<NewsCategory> newsCategoryList = newsCategoryMapper.toNewsCategoryModelList(newsCategoryDTOList);

		Assertions.assertNotNull(newsCategoryList);
		Assertions.assertEquals(1L, newsCategoryList.get(0).getId());
		Assertions.assertEquals("sport", newsCategoryList.get(0).getName());
		Assertions.assertEquals(2L, newsCategoryList.get(1).getId());
		Assertions.assertEquals("media", newsCategoryList.get(1).getName());

	}

	@Test
	void  testGetNewsCategories() {

		NewsCategory newsCategory1 = new NewsCategory();
		newsCategory1.setName("sport");

		NewsCategory newsCategory2 = new NewsCategory();
		newsCategory2.setName("media");

		newsCategoryRepository.save(newsCategory1);
		newsCategoryRepository.save(newsCategory2);

		List<NewsCategoryDTO> newsCategoryDTOList = newsCategoryService.getNewsCategories();

		Assertions.assertNotNull(newsCategoryDTOList);
		Assertions.assertEquals(2, newsCategoryDTOList.size());
		Assertions.assertNotNull(newsCategoryDTOList.get(0).getId());
		Assertions.assertEquals("sport", newsCategoryDTOList.get(0).getName());
		Assertions.assertNotNull(newsCategoryDTOList.get(1).getId());
		Assertions.assertEquals("media", newsCategoryDTOList.get(1).getName());
		newsCategoryRepository.deleteAll();

	}




}



