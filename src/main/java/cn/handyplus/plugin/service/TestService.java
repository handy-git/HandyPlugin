package cn.handyplus.plugin.service;

import cn.handyplus.lib.core.StrUtil;
import cn.handyplus.lib.db.Db;
import cn.handyplus.lib.db.enter.Page;
import cn.handyplus.plugin.enter.Test;

import java.util.List;
import java.util.Optional;

/**
 * test测试
 *
 * @author handy
 */
public class TestService {

    /**
     * 查询全部
     *
     * @return true/成功
     */
    public List<Test> list() {
        return Db.use(Test.class).execution().list();
    }

    /**
     * 分页查询
     *
     * @param pageNum  页数
     * @param pageSize 条数
     * @return 记录
     */
    public Page<Test> page(int pageNum, int pageSize) {
        Db<Test> db = Db.use(Test.class);
        db.where().limit(pageNum, pageSize);
        return db.execution().page();
    }

    /**
     * 根据name查询
     *
     * @param name 姓名
     * @return Test
     */
    public Optional<Test> selectOne(String name) {
        Db<Test> db = Db.use(Test.class);
        db.where().eq(StrUtil.isNotEmpty(name), Test::getName, name);
        return db.execution().selectOne();
    }

    /**
     * 查询条数
     *
     * @return 总数
     */
    public Integer count() {
        return Db.use(Test.class).execution().count();
    }

    /**
     * 新增
     *
     * @param test 入参
     * @return true/成功
     */
    public boolean add(Test test) {
        return Db.use(Test.class).execution().insert(test) > 0;
    }

    /**
     * 批量新增
     *
     * @param testList 入参
     * @return true/成功
     */
    public boolean add(List<Test> testList) {
        return Db.use(Test.class).execution().insertBatch(testList);
    }

    /**
     * 根据id更新name
     *
     * @param id   id
     * @param name 姓名
     * @return true/成功
     */
    public boolean updateById(Integer id, String name) {
        Db<Test> db = Db.use(Test.class);
        db.update().set(Test::getName, name);
        return db.execution().updateById(id) > 0;
    }

    /**
     * 根据id增加age
     *
     * @param id     id
     * @param number 数量
     * @return true/成功
     */
    public boolean addAgeById(Integer id, Integer number) {
        Db<Test> db = Db.use(Test.class);
        db.update().add(Test::getAge, Test::getAge, number);
        return db.execution().updateById(id) > 0;
    }

    /**
     * 根据id删除
     *
     * @param id id
     * @return true/成功
     */
    public boolean deleteById(Integer id) {
        return Db.use(Test.class).execution().deleteById(id) > 0;
    }

}