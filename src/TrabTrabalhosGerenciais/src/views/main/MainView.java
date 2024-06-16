package views.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import views.components.MenuItem;
import views.entities.FinancesView;
import views.entities.PersonView;
import views.entities.ProductView;
import views.entities.NewOrderView;
import views.entities.OrdersView;
import views.entities.ProductUnitView;


public class MainView extends javax.swing.JFrame {

    public MainView() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        instance = this;
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        buildMenu();
    }
    
    public static MainView getInstance() {
        return instance;
    }

    private void buildMenu() {

        MenuItem subMenuRegisterPerson = new MenuItem(null, "Usuários", true, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                alterPanel(new PersonView());
            }
        });
        MenuItem subMenuRegisterProduct = new MenuItem(null, "Produtos", true, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                alterPanel(new ProductView());
            }
        });
        MenuItem subMenuRegisterProductUnit = new MenuItem(null, "Unidades de Produtos", true, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                alterPanel(new ProductUnitView());
            }
        });
        MenuItem menuRegister = new MenuItem(null, "Cadastros", false, null, subMenuRegisterPerson, subMenuRegisterProduct, subMenuRegisterProductUnit);

        MenuItem subMenuSaleTableControl = new MenuItem(null, "Controle de Pedidos", true, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                alterPanel(new OrdersView());
            }
        });
        MenuItem subMenuSaleOrder = new MenuItem(null, "Pedidos", true, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                alterPanel(new NewOrderView(0));
            }
        });
        MenuItem menuSale = new MenuItem(null, "Vendas", false, null, subMenuSaleTableControl, subMenuSaleOrder);
        //Finance Menu
        MenuItem subMenuFinanceCashControl = new MenuItem(null, "Controle de Caixa", true, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                        alterPanel(new FinancesView());
                }
        });
        MenuItem menuFinance = new MenuItem(null, "Finanças", false, null, subMenuFinanceCashControl);
        
        
        addMenu(menuRegister, menuSale, menuFinance);
    }

    private void addMenu(MenuItem... menu) {
        for (int i = 0; i < menu.length; i++) {
            menus.add(menu[i]);
            ArrayList<MenuItem> subMenu = menu[i].getSubMenu();
            for (MenuItem m : subMenu) {
                addMenu(m);
            }
        }
        menus.revalidate();
    }
    
    public void alterPanel(JInternalFrame panel){
        panelBody.removeAll();
        panelBody.add(panel);
        panelBody.repaint();
        panelBody.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code"> 
    private void initComponents() {
        panelHeader = new javax.swing.JPanel();
        panelMenu = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        menus = new javax.swing.JPanel();
        panelBody = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelHeader.setBackground(new java.awt.Color(173, 148, 100));
        panelHeader.setPreferredSize(new java.awt.Dimension(561, 50));

        javax.swing.GroupLayout panelHeaderLayout = new javax.swing.GroupLayout(panelHeader);
        panelHeader.setLayout(panelHeaderLayout);
        panelHeaderLayout.setHorizontalGroup(
            panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1035, Short.MAX_VALUE)
        );
        panelHeaderLayout.setVerticalGroup(
            panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        getContentPane().add(panelHeader, java.awt.BorderLayout.PAGE_START);

        panelMenu.setBackground(new java.awt.Color(173, 148, 100));
        panelMenu.setPreferredSize(new java.awt.Dimension(250, 384));

        jScrollPane1.setBorder(null);

        menus.setBackground(new java.awt.Color(173, 148, 100));
        menus.setLayout(new javax.swing.BoxLayout(menus, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(menus);

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
        );

        getContentPane().add(panelMenu, java.awt.BorderLayout.LINE_START);

        panelBody.setBackground(new java.awt.Color(255, 255, 255));
        panelBody.setLayout(new java.awt.BorderLayout());
        getContentPane().add(panelBody, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>                        

    /*public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainView().setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel menus;
    private javax.swing.JPanel panelBody;
    private javax.swing.JPanel panelHeader;
    private javax.swing.JPanel panelMenu;
    // End of variables declaration//GEN-END:variables
    private static MainView instance;
}
