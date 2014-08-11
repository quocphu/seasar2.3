package examples.service.impl;

import java.util.List;

import org.seasar.framework.container.S2Container;
import org.seasar.framework.container.factory.S2ContainerFactory;

import examples.dao.BookDao;
import examples.service.BookService;

public class BookServiceImpl implements BookService {

	private BookDao bookDao;
	@Override
	public List searchBook(String category) {
		// TODO Auto-generated method stub
		  List books;
		
		String PATH = "examples/dao/BookDao.dicon";
		S2Container container = S2ContainerFactory.create(PATH);
        container.init();
        try {
            // 通常の検索
            BookDao dao = (BookDao) container.getComponent(BookDao.class);
            books = dao.findByCategory(category);

        } finally {
            container.destroy();
        }
		
		return books;
	}

}
