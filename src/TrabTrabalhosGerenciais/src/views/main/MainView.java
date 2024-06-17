package views.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
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
        
        setLocationRelativeTo(getParent());
        URL urlIcon = getClass().getResource("/images/systemIcon.png");
        ImageIcon imageIcon = new ImageIcon(urlIcon);
        this.setIconImage(imageIcon.getImage());
        
        instance = this;
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.panelBody.setBackground(new Color(217,217,217));        
        this.panelHeader.setVisible(false);
        
        this.addPrincipalImage();
        
        buildMenu();
    }
    
    private void addPrincipalImage(){
        URL url = getClass().getResource("/images/Logo.png");
        ImageIcon originalIcon = new ImageIcon(url);
        Image scaledImage = originalIcon.getImage().getScaledInstance(800, 800, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel jLabel1 = new JLabel(scaledIcon);
        jLabel1.setHorizontalAlignment(JLabel.CENTER);
        jLabel1.setVerticalAlignment(JLabel.CENTER);
        this.panelBody.setLayout(new BorderLayout());
        this.panelBody.add(jLabel1, BorderLayout.CENTER);
    }
    
    public static MainView getInstance() {
        return instance;
    }
    
    private ImageIcon getIcon(String filaPath){
        URL url = getClass().getResource(filaPath);
        ImageIcon originalIcon = new ImageIcon(url);
        Image scaledImage = originalIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        
        return new ImageIcon(scaledImage);
    }

    private void buildMenu() {
        ImageIcon registerIcon = getIcon("/images/register.png");        
        ImageIcon saleIcon = getIcon("/images/sale.png");
        ImageIcon financeIcon = getIcon("/images/finance.png");        
        ImageIcon userIcon = getIcon("/images/PersonIcon.png");
        ImageIcon productIcon = getIcon("/images/ProductViewIcon.png");
        ImageIcon productUnitIcon = getIcon("/images/ProductUnitIcon.png");
        ImageIcon orderIcon = getIcon("/images/NewOrderViewIcon.png");
        ImageIcon orderViewIcon = getIcon("/images/OrdersViewIcon.png");
        ImageIcon cashRegisterIcon = getIcon("/images/cashRegister.png");

        MenuItem subMenuRegisterPerson = new MenuItem(userIcon, "Usuários", true, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                alterPanel(new PersonView());
            }
        });
        MenuItem subMenuRegisterProduct = new MenuItem(productIcon, "Produtos", true, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                alterPanel(new ProductView());
            }
        });
        MenuItem subMenuRegisterProductUnit = new MenuItem(productUnitIcon, "Unidades de Produtos", true, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                alterPanel(new ProductUnitView());
            }
        });
        MenuItem menuRegister = new MenuItem(registerIcon, "Cadastros", false, null, subMenuRegisterPerson, subMenuRegisterProduct, subMenuRegisterProductUnit);

        MenuItem subMenuSaleTableControl = new MenuItem(orderViewIcon, "Controle de Pedidos", true, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                alterPanel(new OrdersView());
            }
        });
        MenuItem subMenuSaleOrder = new MenuItem(orderIcon, "Pedidos", true, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                alterPanel(new NewOrderView(0));
            }
        });
        MenuItem menuSale = new MenuItem(saleIcon, "Vendas", false, null, subMenuSaleTableControl, subMenuSaleOrder);
        //Finance Menu
        MenuItem subMenuFinanceCashControl = new MenuItem(cashRegisterIcon, "Controle de Caixa", true, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                        alterPanel(new FinancesView());
                }
        });
        MenuItem menuFinance = new MenuItem(financeIcon, "Finanças", false, null, subMenuFinanceCashControl);
        
        
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
        try {
            panel.setMaximum(true);
        } catch (java.beans.PropertyVetoException e) {
            e.printStackTrace();
        }
        
        panelBody.repaint();
        panelBody.revalidate();
        
        this.addPrincipalImage();        
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel menus;
    private javax.swing.JPanel panelBody;
    private javax.swing.JPanel panelHeader;
    private javax.swing.JPanel panelMenu;
    // End of variables declaration//GEN-END:variables
    private static MainView instance;
}
