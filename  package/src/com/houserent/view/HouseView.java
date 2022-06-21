package com.houserent.view;

import com.houserent.domain.House;
import com.houserent.service.HouseService;
import com.houserent.utils.Utility;

/**
 * 1.显示菜单
 * 2.接受用户的输入
 * 3.调用HouseService完成对房屋信息的各种操作
 */
public class HouseView {
    private boolean loop = true;
    private char key = ' ';
    private HouseService houseService = new HouseService(10);//假定设置数组的大小为十个

    //编写list house 显示房屋列表
    public void ListHouse() {
        System.out.println("\n==================房屋列表==================");
        System.out.println("编号\t房主\t电话\t地址\t月租\t状态(未出租/已出租)");
        House[] houses = houseService.list();//把所有的房屋信息都存进去
        for (int i = 0; i < houses.length; i++) {
            if (houses[i] == null) break;
            System.out.println(houses[i]);
        }
        System.out.println("===============房屋列表显示完毕==================");
    }

    public void AddHouse() {
        //接受输入，创建house对象
        System.out.println("==================添加房屋==================");
        System.out.println("姓名：");
        String name = Utility.readString(8);
        System.out.println("电话：");
        String phone = Utility.readString(12);
        System.out.println("地址：");
        String address = Utility.readString(16);
        System.out.println("月租：");
        int rent = Utility.readInt();
        System.out.println("状态：");
        String state = Utility.readString(3);

        //创建一个新的house对象,id是系统分配的，用户不能输入
        House newhouse = new House(1, name, phone, address, rent, state);
        if (houseService.add(newhouse)) {
            System.out.println("==================添加房屋成功==================");
        } else {
            System.out.println("添加房屋失败");
        }
    }

    //编写deleteHouse
    public void delHouse() {
        System.out.println("==================删除房屋==================");
        System.out.println("请输入待删除房屋的标号(-1退出)");
        int delId = Utility.readInt();
        if (delId == -1) {
            System.out.println("放弃删除房屋");
            return;
        }
        char choice = Utility.readConfirmSelection();//该方法本身就有循环判断的罗技
        if (choice == 'Y') {
            if (houseService.del(delId)) {
                System.out.println("==================删除房屋成功==================");
            } else {
                System.out.println("==================删除房屋失败==================");
            }
        } else {
            System.out.println("==================放弃删除房屋==================");
        }
    }

    public void exit() {
        char c = Utility.readConfirmSelection();
        if (c == 'Y') {
            loop = false;
        }
    }

    public void findHouse() {
        System.out.println("==================查找房屋==================");
        System.out.println("请输入你要查找的id(-1退出)");
        int findid = Utility.readInt();
        if (findid == -1) {
            System.out.println("放弃删除房屋");
            return;
        }
        if (houseService.find(findid) != null) {
            House house = houseService.find(findid);
            System.out.println("==================查找房屋成功==================");
            System.out.println("编号\t房主\t电话\t地址\t月租\t状态(未出租/已出租)");
            System.out.println(house);
        } else {
            System.out.println("==================查找房屋失败==================");
        }
    }

    public void amendHouse() {
        System.out.println("==================修改房屋==================");
        System.out.println("请输入你要修改的id(-1退出)");
        int amend_id = Utility.readInt();
        if (amend_id == -1) {
            System.out.println("放弃删除房屋");
            return;
        }
        House house = houseService.find(amend_id);
        System.out.println("姓名" + house.getName() + ":");
        String name = Utility.readString(8);
        System.out.println("电话" + house.getPhone() + ":");
        String phone = Utility.readString(12);
        System.out.println("地址" + house.getAddress() + ":");
        String address = Utility.readString(16);
        System.out.println("月租" + house.getRent() + ':');
        int rent = Utility.readInt();
        System.out.println("状态" + house.getState() + ":");
        String state = Utility.readString(3);

        House amend_house = new House(amend_id, name, phone, address, rent, state);
        if (houseService.amend(amend_house, amend_id)) {
            System.out.println("==================修改房屋成功==================");
        } else {
            System.out.println("修改房屋失败");
        }
    }


    //显示主菜单
    public void mainMenu() {
        do {
            System.out.println("===============房屋出租系统===============");
            System.out.println("\t\t\t1 新 增 房 源");
            System.out.println("\t\t\t2 查 找 房 屋");
            System.out.println("\t\t\t3 删 除 房 屋 信 息");
            System.out.println("\t\t\t4 修 改 房 屋 信 息");
            System.out.println("\t\t\t5 房 屋 列 表");
            System.out.println("\t\t\t6 退 出");
            System.out.println("请输入你的选择(1-6)");
            key = Utility.readChar();
            switch (key) {
                case '1':
                    System.out.println("新增");
                    AddHouse();
                    break;
                case '2':
                    System.out.println("查找");
                    findHouse();
                    break;
                case '3':
                    System.out.println("删除");
                    delHouse();
                    break;
                case '4':
                    System.out.println("修改");
                    amendHouse();
                    break;
                case '5':
                    System.out.println("列表");
                    ListHouse();
                    break;
                case '6':
                    exit();
                    break;
            }

        } while (loop);
    }
}
