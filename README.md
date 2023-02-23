# Proyecto_API_REST


<p><br></p>
<p>Base de datos</p>
<p>Esta base de datos cuenta con 4 tablas:</p>
<p><img src="https://lh6.googleusercontent.com/jS2SJP3tDT7hJ_QwX1gsOku72bpac4-I0zjbSRyWdpKMRwsD91hzeeJw17Jk6iAd3Q_PIoPveYIHKhn1pZkJFge_RMBRzEW-NfInjn8KJWHV0z_WL0RSSWEsSSZMN67Dz5zybHGXUf06jSkt-TTurHw" width="666" height="148"></p>
<ul>
    <li>
        <p>Categor&iacute;as</p>
        <ul>
            <li>
                <p>CREATE TABLE Categorias (</p>
            </li>
            <li>
                <p>&nbsp; id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,</p>
            </li>
            <li>
                <p>&nbsp; nombre VARCHAR(50) NOT NULL</p>
            </li>
            <li>
                <p>)ENGINE=InnoDB;</p>
            </li>
            <li>
                <p>&mdash;-----------------------------------------------------------------------------</p>
            </li>
            <li>
                <p>INSERT INTO Categorias (id, nombre) VALUES</p>
            </li>
            <li>
                <p>&nbsp; (1, &apos;Smartphones&apos;),</p>
            </li>
            <li>
                <p>&nbsp; (2, &apos;Laptops&apos;),</p>
            </li>
            <li>
                <p>&nbsp; (3, &apos;Accesorios&apos;);</p>
            </li>
        </ul>
    </li>
</ul>
<p><br></p>
<p>&nbsp; &nbsp;&nbsp;</p>
<ul>
    <li>
        <p>Pedidos</p>
        <ul>
            <li>
                <p>CREATE TABLE Pedidos (</p>
            </li>
            <li>
                <p>&nbsp; id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,</p>
            </li>
            <li>
                <p>&nbsp; cliente_nombre VARCHAR(50) NOT NULL,</p>
            </li>
            <li>
                <p>&nbsp; fecha DATE NOT NULL</p>
            </li>
            <li>
                <p>)ENGINE=InnoDB;</p>
            </li>
            <li>
                <p>&mdash;-------------------------------------------------------------------------------------</p>
            </li>
            <li>
                <p>INSERT INTO Pedidos (id, cliente_nombre, fecha) VALUES</p>
            </li>
            <li>
                <p>&nbsp; (1, &apos;Juan P&eacute;rez&apos;, &apos;2022-02-01&apos;),</p>
            </li>
            <li>
                <p>&nbsp; (2, &apos;Ana Garc&iacute;a&apos;, &apos;2022-02-10&apos;),</p>
            </li>
            <li>
                <p>&nbsp; (3, &apos;Carlos L&oacute;pez&apos;, &apos;2022-02-15&apos;);</p>
            </li>
        </ul>
    </li>
</ul>
<p><br></p>
<ul>
    <li>
        <p>Productos</p>
        <ul>
            <li>
                <p>CREATE TABLE Productos (</p>
            </li>
            <li>
                <p>&nbsp; id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,</p>
            </li>
            <li>
                <p>&nbsp; nombre VARCHAR(50) NOT NULL,</p>
            </li>
            <li>
                <p>&nbsp; descripcion TEXT,</p>
            </li>
            <li>
                <p>&nbsp; precio DECIMAL(10,2),</p>
            </li>
            <li>
                <p>&nbsp; categoria_id INT,</p>
            </li>
            <li>
                <p>&nbsp; FOREIGN KEY (categoria_id) REFERENCES Categorias(id)</p>
            </li>
            <li>
                <p>)ENGINE=InnoDB;</p>
            </li>
            <li>
                <p>&mdash;------------------------------------------------------------------------------------------</p>
            </li>
            <li>
                <p>INSERT INTO Productos (id, nombre, descripcion, precio, categoria_id) VALUES</p>
            </li>
            <li>
                <p>&nbsp; (1, &apos;iPhone 12 Pro Max&apos;, &apos;El &uacute;ltimo iPhone de Apple con pantalla OLED y c&aacute;mara triple&apos;, 1099.99, 1),</p>
            </li>
            <li>
                <p>&nbsp; (2, &apos;Samsung Galaxy S21&apos;, &apos;El &uacute;ltimo smartphone de Samsung con pantalla AMOLED y c&aacute;mara triple&apos;, 899.99, 1),</p>
            </li>
            <li>
                <p>&nbsp; (3, &apos;MacBook Pro&apos;, &apos;Laptop de Apple con procesador Intel Core i5 y pantalla Retina&apos;, 1499.99, 2),</p>
            </li>
            <li>
                <p>&nbsp; (4, &apos;Dell XPS 13&apos;, &apos;Laptop de Dell con procesador Intel Core i7 y pantalla 4K&apos;, 1299.99, 2),</p>
            </li>
            <li>
                <p>&nbsp; (5, &apos;Funda para iPhone 12&apos;, &apos;Funda de silicona para iPhone 12&apos;, 19.99, 3),</p>
            </li>
            <li>
                <p>&nbsp; (6, &apos;Cargador inal&aacute;mbrico&apos;, &apos;Cargador inal&aacute;mbrico para smartphones compatibles con Qi&apos;, 29.99, 3);</p>
            </li>
        </ul>
    </li>
</ul>
<p><br></p>
<ul>
    <li>
        <p>Productos_Pedidos</p>
        <ul>
            <li>
                <p>CREATE TABLE Productos_Pedidos (</p>
            </li>
            <li>
                <p>&nbsp; producto_id INT NOT NULL,</p>
            </li>
            <li>
                <p>&nbsp; pedido_id INT NOT NULL,</p>
            </li>
            <li>
                <p>&nbsp; cantidad INT,</p>
            </li>
            <li>
                <p>&nbsp; PRIMARY KEY (producto_id, pedido_id),</p>
            </li>
            <li>
                <p>&nbsp; FOREIGN KEY (producto_id) REFERENCES Productos(id),</p>
            </li>
            <li>
                <p>&nbsp; FOREIGN KEY (pedido_id) REFERENCES Pedidos(id)</p>
            </li>
            <li>
                <p>)ENGINE=InnoDB;</p>
            </li>
            <li>
                <p>&mdash;---------------------------------------------------------------------------------</p>
            </li>
            <li>
                <p>INSERT INTO Productos_Pedidos (producto_id, pedido_id, cantidad) VALUES</p>
            </li>
            <li>
                <p>&nbsp; (1, 1, 1),</p>
            </li>
            <li>
                <p>&nbsp; (2, 1, 2),</p>
            </li>
            <li>
                <p>&nbsp; (3, 2, 1),</p>
            </li>
            <li>
                <p>&nbsp; (4, 2, 1),</p>
            </li>
            <li>
                <p>&nbsp; (1, 2, 1),</p>
            </li>
            <li>
                <p>&nbsp; (5, 3, 2);</p>
            </li>
        </ul>
    </li>
</ul>
<p><br></p>
<p><br></p>
<p>Creaci&oacute;n y configuraci&oacute;n del proyecto</p>
<ol>
    <li>
        <p>Creaci&oacute;n de un nuevo proyecto Spring Initializr:</p>
    </li>
</ol>
<p><img src="https://lh6.googleusercontent.com/8WVLAOeqsu5z35CfkYMOuuat5c9aXBb32Pb_ykNPsC_B-t8LusoywYQaZ22uhMhJR3lh0QBMHNmA0Cw0f_FoY-VdYRYoJNVe9rLiNV67AnFdx7nhyoVFoHEo4faajyuaR8VNUZvNmUp3KY0KXpr-wxs" width="602" height="481"></p>
<p><br></p>
<ol start="2">
    <li>
        <p>Agregaci&oacute;n de las siguientes dependencias:</p>
    </li>
</ol>
<p><img src="https://lh3.googleusercontent.com/iO1e87JQRYgHWZuItfCwUkPVe8Zsw26d57GpbAtxukfe6bwJ2Dr-IDjfBzptunis8dBOZm2V9bGKOYVbGc2rpha8f0Ga85M476osOeOUL6-v8_FJKfQ3fYFYMZVWjDQiKnReFbAp_lbeFNWhyMrPHNA" width="602" height="488"></p>
<p><br></p>
<ol start="3">
    <li>
        <p>Habilitamos la pesta&ntilde;a persistence: View&gt;Tools windows&gt;Persistence.</p>
    </li>
</ol>
<p><img src="https://lh6.googleusercontent.com/kH8-8ixH_-aU0WAMu4xwP28RI8IhtuB3PW4TwAaTdeQ4ziHZdO3dsORxK88unY5-29FugO-ibz13bzOa5Y2cJID8GpSjmHsB-f1rqw9_zC6vaWPmg48jP1_rB0V6hMufPOHQDWdSFGq5q-Wv_y7-LdQ" width="497" height="470"></p>
<p><br></p>
<ol start="4">
    <li>
        <p>Configuracion de la base de datos Mysql: Database&gt;+&gt;DataSource&gt;Mysql</p>
    </li>
</ol>
<p><img src="https://lh4.googleusercontent.com/kFldV7MQxv0qTtrZyRrCJejgLFy6YUWx-TMMt3OYwKsiztVq_KETMZqk2sUDap4FQDxAjFeYtyDslvepOECvzHZN93WuqWXaWABw5PQuQ-cgAJL7DF1WqT5f4vuWEBcyDUsWEpY1TkdC31ZBkJ18qkc" width="602" height="508"></p>
<p><img src="https://lh6.googleusercontent.com/0n9gOLkULpLZTfZnS6LOr5hWnbxFC1sm6X1OuMxrF0eSWvXJt-4Stt_V_oHUhpF2oKXL1VYxozgwylvWcG662SK_BrxwB6ITlBct5V-pTjt_06PZSMsSQUS2Mdm1gjkIbbGPLid_3f6glWBFiJoMyHk" width="334" height="182"></p>
<p><br></p>
<ol start="5">
    <li>
        <p>Creaci&oacute;n del hibernate: File&gt;Project Structure&gt;Facets&gt;+&gt;Hibernate y agregamos el hibernate.cfg.xml</p>
    </li>
</ol>
<p><img src="https://lh5.googleusercontent.com/THW-1FF1W5bVFiTThPI1-aS8eJk0a22hlzNaKo87GY7QNQLKO37TKMBQuZy2_gbwLNUbYTvBq46RnlB4xBsycgXqIyvgKijQDbV1LY9mIoQHs0hln51aK_WBAG0TkpRJPO0oeHVW3x7EzFxUr0m2Hdc" width="602" height="496"></p>
<p><img src="https://lh3.googleusercontent.com/aJNaky41ek9SPnsYsYxVBDVbDKp56cCAxG3XLWAnJYDXmFMctOAscanckZfavBrjrhqXmCXKyBPEm3bTAqYK1tsGtva9pGzi0vAqfPzgKyDjg6Ial2jEXql5s0pUiJfOMnZl5fgthPOwPTazeNcB1TU" width="437" height="268"></p>
<p><br></p>
<ol start="6">
    <li>
        <p>Hacemos clic sobre el &gt; Generate Persistence Mapping&gt;By database schema:</p>
    </li>
</ol>
<p><img src="https://lh6.googleusercontent.com/7S1fbaXnOUxnzNUFGUFZulBv4bE1QApGfiDQFqsr8j_Zq4Y9tqEfR1keAE3GMjH108s9qs_W-eyFqjuG07Gv820TnNUOrnZvoFWsP5qlQ1abkpLbwl3yuKAjFByhRcOfwFUU583xfEjSsjeG_RiaM6o" width="602" height="589"></p>
<p><br></p>
<p>Clases generadas:</p>
<p>CategoriasClass.java</p>
<p><img src="https://lh3.googleusercontent.com/WmJYim5CuOXud22iO-A68_LBNumt0cNtRCVlG-K8fTPt2TwY06I7AEBce4A2mtNSbDHKN7CsT6WA7y8z9bVjFKgj9ZqNnbd89ePrXq0nWonglE4oFeujgfYhYoUEkT59j0lP6nEG46CK5HmVSDxPh3c" width="602" height="408"></p>
<p><img src="https://lh4.googleusercontent.com/uC95Af3yy_3BJRSbf5jpVsf4qXHErWymF5K367w7dcR_GHo3BGORoS227mKGB93y47KGimCyr23SuUFy0hBYXcPRgF7ZWKGIDTjU0gt_YEuHkbjWURm53lQer93UZJpWK3Yqz1yMVtTYx3MfAAcpWkk" width="602" height="263"></p>
<p><br></p>
<p>PedidosClass.java</p>
<p><img src="https://lh6.googleusercontent.com/IXREYgFkn0WvNAPjXoQVyJe0twbgVN3KZqIhW8-68MaGwFHbuM-Nz3rn_giPqwwW0I38FBlikrcSOoyWjiMV7JnjTcrygQetc3Y_e91Tt71Kkou7H-ziRu8YfpwVfCqSk05rUHxOZ8-92kv8ylIEygE" width="602" height="528"></p>
<p><img src="https://lh3.googleusercontent.com/MIZuuujXyUYagR3CANoJMiSNBBtCH960QruovWgnASQd8QTMbNyXm37P7ksMLkDaPTULoEbRtCDvkqzcwJq0166gyG-5FnQ-UX_b-DRe_48cTmM-LPpuKsykUdHieHqu3RjZdWLiWPlMW-P9ZwD9Wow" width="602" height="353"></p>
<p><br></p>
<p>ProductosClass.java</p>
<p><img src="https://lh5.googleusercontent.com/K0ib0c2o3GRp1uS5SrN32b-KrdNhWgAjUHiIwoXDW4g6B0m8ogmPCpbOZ090WYgtu5o4CTrSmpNzPrAqaWeyRObfUQ39M7lixIthsZFOgrrrEYaSnRIvbAJNDB-JQIQGGIAmevSqD-aM2D73FFZE3L4" width="602" height="444"></p>
<p><img src="https://lh6.googleusercontent.com/aLAbHe4AgJ_esRzVil3aWrLISLS_I3qq0RfC5vKiVwEnh-9ceI7-5dPOTIlmLD-qaIQOXV6J1BBM88zq4BUfU8UYcmT10i0afjqaWquFgo_uvIfE6iWKYPXe_yuTyLugRGSJkfblhi9FUCrMqobZaLU" width="602" height="377"></p>
<p><img src="https://lh5.googleusercontent.com/AtITh3yM6KOE7f5tpd70Eit7Y3KIdLheqbbkr5yZwXYcuIjCi9tco6doyn8EHxxXKuWaHjPfyXdjFB0sXrtIreAWQXIe-2jQ2YgkIA0_z0nEXcvG4WtmcQJm71QN_OdXrXkWZmQtNcixoHzXLsvK-E0" width="602" height="349"></p>
<p><br></p>
<p>ProductosPedidosClass.java</p>
<p><img src="https://lh6.googleusercontent.com/xU0ZKc98ASHWQS3fG3buRvsDYASsAUEr2-otTCEKl_mpE-i7l1O8RxEsMp7vzu7-HwL75MhWjd6XO2WNglKRU4xS8TpI1WJWlN-V_R-nMNghYtOXiihiEQppX1WYeKl-yGPiB-OWRqikuppX37ZC7to" width="602" height="516"></p>
<p><img src="https://lh5.googleusercontent.com/MMVJSuVykanTEhRG9nORe1lgDZmKK0d_rBBYMhDwZXowTicLKhzVH5OPxxrSSHbuv36rBh0j_Lmz6IK8EybEc7AiyklHnCOHBniRAeIGmL-GC3O5F2t4WWsr2jc6-GKI2YDXdNeh1UYoaJY93in2FUs" width="602" height="504"></p>
<p><br></p>
<p>ProductosPedidosClassPK.java</p>
<p><img src="https://lh4.googleusercontent.com/cJ_tonc4jffR_F-EV-aLtdfYA3pANha7WyoZN7XKF5hCmjpYfxj5hqGkU6mICHntBabnOOP0JKk1Luqwrt17lM67yc7idxJOm02z4aFCi4CgR4qsWdMZDjfqFtei2tK5J13oIs46v3Ui5NlUrTuV8ZI" width="602" height="496"></p>
<p><img src="https://lh3.googleusercontent.com/VcmLbb098enG8AoyIP40tAS1FjNKDkrOpSOlxZ0MlUAXXQS_8EPDI1R66T6dmCg_15wPL3_fh94AD-9a5sKNXoBT8bwfhPdqGs8gd18y4sgL03_n8mTcp9qkqhoPojTEYePJacIyb1bxrGNDt8xMGqI" width="602" height="276"></p>
<p><br></p>
<ol start="7">
    <li>
        <p>Configuraci&oacute;n&nbsp;application.properties: Debemos agregar el username de la base de datos con su respectiva contrase&ntilde;a, el base-path de nuestra api y un puerto que no est&eacute; en uso:</p>
    </li>
</ol>
<p><img src="https://lh4.googleusercontent.com/JqHmYHcH6M3T-RiiRstnw6604M7Yk6SfGuv8yzfxLyh4LmNyP8zJwUXvizm0fUQrg8nnqUuoPthf_HTzaKScbn_qLzp9NM9m8zEo2EP1pvvchqnofosaQ7A2Z4sOghsO240QmAjWv7l26PZzPj-oNHo" width="602" height="225"></p>
<p><br></p>
<p>Creaci&oacute;n de los DAO</p>
<ol>
    <li>
        <p>Estas clases extienden de CrudRepository donde le pasamos la clases generadas anteriormente:</p>
    </li>
</ol>
<p>&nbsp; &nbsp;&nbsp;ICategoriasDAO</p>
<p>&nbsp; &nbsp;&nbsp;<img src="https://lh3.googleusercontent.com/0-18hI03Ng5EcMiGfrVbnb-oAbC9iu8ScCqGhNVRNYeKtuACLIt1T1hsdGiA9vfTtQOxAVjWkNDwuPx7PJJQFBb_LsPwsD_HJOgwHFihjincUJpCyZT5nd8Sf0V6HRAfwj5RKVYI4VqYzPM7A34Fktc" width="602" height="160"></p>
<p>&nbsp; &nbsp;&nbsp;</p>
<p>&nbsp; &nbsp;&nbsp;IPedidosDAO</p>
<p>&nbsp; &nbsp;&nbsp;<img src="https://lh4.googleusercontent.com/7iR8UPqc0jUue3YUo8HI-MRZvJKEfeXrtMh2jho27Wt-DuZ7kMpvl74b_VS_dGUQrrhUG3BG_AJFu2XnKfge2MGi-YzeA3JebZBObXj5bZVXojfcrK02ry1r70mEvMhEQffRp0VsFLxHYlTxbUIaqeg" width="602" height="204"></p>
<p>&nbsp; &nbsp;&nbsp;</p>
<p>&nbsp; &nbsp;&nbsp;IProductosDAO</p>
<p><img src="https://lh4.googleusercontent.com/uXnaXgvvuG1UwpDL5ec5pH2jTiocpxmUA8cosrq3eZgXHqB-zypXW15yQV7p7H7rbxRAuVqFyGcyOLnhk_DjYZFw1w-FoOJHrOIe66JZIvbyHQUkHYw_HlGCUt0_-IzSO4lBZo8xdj2kw-2ei3zeJ2U" width="602" height="207">&nbsp; &nbsp;&nbsp;</p>
<p>&nbsp; &nbsp;&nbsp;IProductosPediddosDAO</p>
<p><img src="https://lh3.googleusercontent.com/WH41tOmZSbEeEuWw6DbZCFnPY5YH9M4s6BpwTG3jhV2zRThPp3Hh3caZKJ21tKMDUK_7PnGnGjs_r1SIqqOrbmnP3g9VFsAMMalDijyTrElI6128C4Ekbjb5aiCWmtIAHvfyGKCZNvUs_OlYsUOraXo" width="602" height="195"></p>
<p><br></p>
<p>Creaci&oacute;n de los controladores</p>
<ul>
    <li>
        <p>ControladorCategorias</p>
    </li>
</ul>
<p><img src="https://lh6.googleusercontent.com/x5-XejmS5dCclp_pv3Hmb29vdxP0HQGvnc-ZGH-5Lgf6c6cStxeEuoha_OdbOAhngzj8sls5D7g0TYCgjjKhjjOB1BUuTAK9osPtUk-Djica6PcQUFf6-pWY7eqUhwm4JC_tg_74oYoihOf3G-5vqsk" width="602" height="564"></p>
<p><img src="https://lh5.googleusercontent.com/1qNBfapc5G8z72Y87InAA2mrLF5jJCP3XRHW74GoIMiQOwpyEmPOHYzCvzUJ-CvEyw75PMFO9zc1VeUJ_i1tYwK2Y6tL5TMhyc4yTyTwMQDlNRWsJZS-lhGKyvOGDr1piWG4ONTppwd3Z_JsqrVhHEY" width="602" height="511"></p>
<p><img src="https://lh3.googleusercontent.com/wi9zZLyvoKOvgHLksyMUC0j_na1AoQyuKCC-T9K2tKGk3gvOyNEBWR-WripYW1M-J2Znvn87xPrDHNaGD1zACzPDxxR5puWTZlnrLtEyAZKY1F1ybj5j2-DHOKpI_syCrBpmxpE-wtDIxH7rUVkY2Ac" width="602" height="455"></p>
<p><br></p>
<ul>
    <li>
        <p>ControladorPedidos</p>
    </li>
</ul>
<p><img src="https://lh6.googleusercontent.com/DcQ__z3rNaoOJxJElkgmrfnyEZsUat69hiYFcdaet3Rk9rJha8OWWpt_vL-CfyXcKPpmaeBg5d36ORVUCUrJIRCIjELXY9-MSZsVg9IDTdDHqjREi5W8ZVAHAXfHRRJDOa2ICDnFNwZqcptqEvSd62I" width="602" height="551"></p>
<p><img src="https://lh5.googleusercontent.com/38tDnphQD2Jg4z860GedkxqQ1HaXxhp-0yNOETgBCG4r1RCPuCTK6unzPH5dwTRe4jsX-yOttfX35amoiq3iYkELs1PaP1gttmTvQ17P0mdkDhJYhAWZU7uawIP0qeKJWi0hkumX84AeXFq-k-Ammyw" width="602" height="561"></p>
<p><img src="https://lh3.googleusercontent.com/rHYJWBRbvvUgSiElmfROT1YCmNQd3n8ziukaxv67WgMVw16f1pkaoPxkz1l-PlEF13D7-FO2fHSw14qj7nN8EsbyHF0hTLcrVxtndhw4fWgbtHsyW3zyWA8NjX8fnvJDKmP0HDficSj3NWbU51Rtkz8" width="602" height="524"></p>
<ul>
    <li>
        <p>ControladorProductos</p>
    </li>
</ul>
<p><img src="https://lh3.googleusercontent.com/fDMHt4OYKwnuIDXb2jYqKdO8N8301CKZh8OxjUvoYOkkG8Rz_RA98kwjQJHkV5UEAaP8xb87stDggKTV_gecujQKlNXIRvIyrtxQxe1y9Jeb01a4E4_ZIN0fNeykCcONRWZ_QOsvw4RVFGMhdBvCZrY" width="602" height="585"></p>
<p><img src="https://lh6.googleusercontent.com/_6BiYEi1Oegqg6B4tu0aTsOE1lVyPxaih4DfuT2il1LNykjpwSHbDYCNO9zmVozRy4wuXxo8EB6WyLxdSm95awyIBuVM5FtpgnREgR2W3bVH4fS9sndl83bfAKUQ_RTEFU6iAWJAwAG6yalf00nAsCc" width="602" height="312"></p>
<p><img src="https://lh5.googleusercontent.com/uzctFoo4w2H5tms6374BdYQMzeQ_lKvK8WAXsFNhXFV7Up1gfuLUDLpLixwlGJiTVHMyPQt3gSDfZoB-gpA4a0_Setn3OgEJ8seiBsiztSgVzakw_3FxXu78HFT_nciMvE9iqZurxmVOfbFC8wTTrQQ" width="602" height="383"></p>
<p><img src="https://lh6.googleusercontent.com/joPhSWqx-iAFXsu7Fl_Es42hio0O0WOHlAlAoI1jSvn9IwWBwzfY0u4zrtxzpBLXVFkpxQVNRA9CA0DQwIlexqrwjzJd1ezOC40oDhs0aSTSCXs9E3ndPRiNOtPRYOzDz9RVPita5J6CdZXwlLKiI3s" width="602" height="507"></p>
<p><br></p>
<ul>
    <li>
        <p>ControladorProductosPedidos</p>
    </li>
</ul>
<p><img src="https://lh3.googleusercontent.com/Az64IqZJFWoyvqioeljN_0WKGSRgCXHcVl1Z6C9JEU32IRN-CxvPxKQox-DIae-iVkE6R2h90r-2odkNf7LnaG3bqSogTDMHdl-_I683rL-xmhPxRAppPw-q5f1mFG2gqKcHGAZ3aA1ABfSkhwPzcz4" width="602" height="407"></p>
<p><img src="https://lh6.googleusercontent.com/WJfcWvo6efd1Zbb9luTGan4_bFPXWFPWBy__a4nFramapMOE4vAct4Jf0QeeS7aq-qD0YBbVSZ0uSQkZX6nQ-KEvnsRUp8C0ISHsW8u8fopKuxdOZ7Do-JEwEZS_KikxpDTpzB7xFyrh28xn_VAaDnA" width="602" height="523"></p>
<p><img src="https://lh6.googleusercontent.com/NVFyIwdFdeeeZ5swkOhYbryqA0GcC9XZw1mmkObTtQUf0_PBbNu4uktGiQv1mf0KDxPkicrlXeqrVUUmwDhBRQtKIDoh_bR7gc86HrFvq5SC2wrznUG60tNMSwsC5UWS1i3a9NOyhV2_6dWINZKak5M" width="602" height="417"></p>
<p><br></p>
<p>Ejecuci&oacute;n y pruebas realizadas</p>
<ul>
    <li>
        <p>Al ejecutar el programa se nos tendr&iacute;a que quedar en ejecuci&oacute;n, las pruebas la realizaremos con el programa Postman</p>
    </li>
    <li>
        <p><img src="https://lh6.googleusercontent.com/GrG7L9rQEpCAA3PhLwDk8g_lJCaaaaiYAuzoWEVjf1h22dRgocmo9YQoCK3Miu-UoP5b5CdABI4riPcig3xjjhrZHFARGb3ZuE82GVLqkuFnnxhnt1OCtU1Da5Ai1C9OcP5nX9zECV4tn1LatKCdjUU" width="602" height="281"></p>
    </li>
</ul>
<p><br></p>
<p>Categor&iacute;as</p>
<ul>
    <li>
        <p>GET</p>
    </li>
</ul>
<p><img src="https://lh4.googleusercontent.com/fg-lnHSZ8NfF0ev8AI8Nx3WDhGXYPHStlip8K6zZLpv83j99fxAZRhVqKCP5xFeljejMkmzPVtk0dho-b1vOdDNGkYBY2JedPEIiZz-khyc1sU2qqZ_FOjGI765igOUWHv7OND94xnrn3Bae1A5hkqs" width="581" height="398"></p>
<p><img src="https://lh5.googleusercontent.com/j9FzXSTHzzr7rU6ZYwKRiMvRev2J0UG3dJSzwd5-fJQ9-Yaz0Svzrq3OPENY-Zw9mjfw1CRyx5jiOOshp7tDQxOjX5p2XRn97OGw6WDOjMb9FYhyK-C89-9Hl3s-yGPwaMoDkFOGPkLkoSpXbQo5dqw" width="576" height="397"></p>
<ul>
    <li>
        <p>POST</p>
    </li>
</ul>
<p><img src="https://lh4.googleusercontent.com/U45PQKvNa9Aj3FpxiMbcqkjpo9f9FpNwOELIQzz4BEtk6Qh_002ibvsckSP0LlfZA2OvHJ6E7oR43W-G2gSVXGXkn3yvEUM4FK4lqfgAFAvcWQzgCJp5oHxjuPQRAYUql6qI6U41W9qcBWBfWDZKBi8" width="563" height="136"></p>
<p><img src="https://lh5.googleusercontent.com/85MgvrFbHqWBWN42GMuFdlPXIBKTyxnjMDup7BgMWE9mug3vZb287z3vRCpzJ_2BQVZnB-He8qSKLL8sHSaG2Ajcda0578nHB6hu_RmRdv0hgEdf_DIZCiw_Qh889FcWWUfGnRggjv_yV8U4WGbWC94" width="425" height="201"></p>
<p><br></p>
<ul>
    <li>
        <p>PUT</p>
    </li>
</ul>
<p><img src="https://lh5.googleusercontent.com/F8WVdliotv9aD5cgoaj4Z3Zh4d0a44yVA_kBs35mn9NuxidJ5vYxGOVoLZ47Vr4VGAqblJTu0P4Wizkthchx-Ep7ArUstYsaF13rhi-myvuTqWgtXdDyGORJra22ZepsE0lRj27KjtWkFjtqBX7GyD0" width="555" height="258"></p>
<p><img src="https://lh4.googleusercontent.com/o01BkOOHs7iqZaGytKKKys56nxXI0_FLwe9FdbjSNR-FhO3j-l-fme7EIOoD6gL7zQFxexpAhiwv0OZ46OfZRfQlm7O_zQ3F8DJv6UjJ9OZN1cLswdbUKaWQUNZ1jcVmNY3yfAItJZNH3q4JG_GVNlc" width="308" height="163"></p>
<p><br></p>
<p><br></p>
<ul>
    <li>
        <p>DELETE</p>
    </li>
</ul>
<p><img src="https://lh5.googleusercontent.com/FDFMpZ6wVrFzgzvkj5swVRyg4uQQfZHf5CdMh5nX9U0LlnIDG_0TI6pdCCwE_Lt-hGgzgHK9QYSn0kMfVwoioNQMhWL3OUy6D2xoOQVJg5m3UcMOIzv3M3Ejt5bKa618oZTx7eV9xqjSlsrKpjNAD7s" width="565" height="311"></p>
<p><img src="https://lh6.googleusercontent.com/3mqtDK09dST7J9tapML9E6XsKAyB3oxJpu0VZlbx2-qEZGp9nYCbH-kNaBHp3GmvFq6g70X3gNZoj3ZmZVBjH5DY7kXp-Zx10sSiD4Vb8JoKGT_Lf4SFhtZ-fMfcXOxZPltc2Sl_z1Rb_69ZfmEblfs" width="364" height="199"></p>
<p><br></p>
<p>&nbsp; &nbsp;&nbsp;Pedidos</p>
<ul>
    <li>
        <p>GET</p>
    </li>
</ul>
<p><img src="https://lh5.googleusercontent.com/Cc_GeEWp9dD5UHSrAzbSn-oPdz10JygSVmBEnQ-_j7BvbgGQre1mvvm_97se2JAHc_D-KclRZ37vuvp703ZLnKlkk4OuuMWT6TbqbAWSsGxq3Z5q3hVuJPNqDfGbltPY5_2lQKpdpreSgdwmJQZSnYo" width="544" height="544"></p>
<ul>
    <li>
        <p>POST</p>
    </li>
</ul>
<p><img src="https://lh5.googleusercontent.com/8uTdWlpIQVRQcSt2mqWhNKOGzDDVQ-DQbx-h13V5WXHgMbmDmzPIKB30fm7Nt5Y8U-uRWSMqtMZ2UpMQDj0PhHvzzZFLxL1S4B07WDipiZr4oANk4x04ZOzA2iSG-pV1ZuiuAqH7on4yB4QQUNffatk" width="515" height="356"></p>
<p><img src="https://lh6.googleusercontent.com/qe1HS35VYR2_nVgsKvNCmrh6D3jYr6zePqIcogxvi-ei1L0faXjI9Qwg3vhs4ILEdTNQKty5tZDjk8Zt3FZPKTJ74CMqGPeauVJaDhZVw3sGerFKN5Iww1CXr3spdrRjXhP4RN0i7YO-6vpW8mcGzgY" width="503" height="165"></p>
<p><br></p>
<ul>
    <li>
        <p>PUT</p>
    </li>
</ul>
<p><img src="https://lh5.googleusercontent.com/Mh0dL--I0oLkeAkZwSIOEL-lTmrPZJONxRJ0lRwI91nQj_gI5Fzih9YUHUG_ZFLYm8AspKkzEohKljtcE1Q6ztdJhlh6RBhYo5hG_eeSKy29uJD2OhHQ4gUEk_g8doCfnG7sfm3F84VghTJKqoT3wgY" width="568" height="415"></p>
<p><img src="https://lh5.googleusercontent.com/ON_ucyM2S7ZbIC0crXKiYJYTLJblBcBzSv_r3AWb46d8AQngln1BKaZt9Xvs0PyWSY5jAS_Fo7ADhOrVTtgJXfsFkN2qZ0aX3TVpp-BudA7FxccfGhOAwZI8IG4LXFumfu0IyAsab9-wchDQ8GWCq34" width="443" height="140"></p>
<p><br></p>
<ul>
    <li>
        <p>DELETE</p>
    </li>
</ul>
<p><img src="https://lh4.googleusercontent.com/2OCwBZVEf9MRY-18HEknSYqYlgBvHkzBuWoiayBovO18tkF-pyA5Ql3zqV0hPRf5Am0OgICnJgMqnViSfhicpoR38S_5Q4ecDXM5vQ-auoffAsFx3NJAP8-1_oc8welzE1c6IxunTThPf4RG1OnKimk" width="551" height="355"></p>
<p><img src="https://lh5.googleusercontent.com/b-HKLZZuvgTR_iwx0eDxgVnbrKl_PcFtdHA6Tu-1yyQHXbsnSY-dP7WeSte7ZOymbJJ9Jpx3be4RxAViV9jV5fn2jhHR3zAsmrhVsCQUTWaZuGBlucQwI8nEHG38HBaiI34SPn2CBE6teT9Y88_oJaY" width="457" height="149"></p>
<p><br></p>
<p>Productos</p>
<ul>
    <li>
        <p>GET</p>
    </li>
</ul>
<p><img src="https://lh6.googleusercontent.com/e-tBi0a3yjRI975Abbc-8UP8d1x1Z1wmZSZArlDnYzkowDHumSEklBVdk9vpbEsxcV41rbV8UC_74_iP9QGAXhJljqflYneLt_RF9Uhbigvybj8gkZhYXwFrM_hdAM4DuLPvIRKBX39-5cRS68dfev0" width="571" height="471"></p>
<ul>
    <li>
        <p>POST</p>
    </li>
</ul>
<p><img src="https://lh3.googleusercontent.com/pOMViY5qO7sWWqm-7RGbgfcftv5Sa3W_5UX7gYw9fim8GANgaN05enIu5wl8KxC47cznNIE9GrS-g2B1u-ED6DpPknpfXDalS0somHuj4wGXzeIXAzGGvrz_dbAFUUSRiOSbw2zaYbgE4Hee83uw0PU" width="576" height="337"></p>
<p><img src="https://lh4.googleusercontent.com/sPVi-3dlI4xSb9GC46QRvbro5GsT66djZ63mfhol7MkEf2uP_NvrtHnepE_TPFZpo2BKDqm20hF3CYZQsdS4uCUzKTG9QOsw9uKsDe9igCAmnM4eadF3-u96fFHw4hBNqc7D4jAPEhlWvgbax7iqH6Y" width="559" height="190"></p>
<p><br></p>
<ul>
    <li>
        <p>PUT</p>
    </li>
</ul>
<p><img src="https://lh4.googleusercontent.com/VIrSI_79VFFBnSGrMCM-QZABS2CdwWBL1e0MvizVd3AfOeJSqb7ZZTCo62Rg-5n9ZDOiD5VcT4ggbJyNFNbc1gpgMdqBOXh7wAw4bC4AAAcatIxFvRp8q0DiDyKm9K_dzRH7UQC9qwOZpEQcPgsRUiA" width="570" height="356"></p>
<p><img src="https://lh5.googleusercontent.com/c3577N9tEFsc8LDrAo3aSiZ9wDE0Arx-_MPuu0Iw9jKtkHU3Mh7X1uFx-mWb0W1QthD-qMzDCEjcXToy2q9PBG_Me_ZBmtOrJz6ccEzbXGNchv9XIbvRkq1_HMpyqD6UKsdTheDnoIfsfQKA8tpCJ7U" width="541" height="171"></p>
<p><br></p>
<ul>
    <li>
        <p>DELETE</p>
    </li>
</ul>
<p><img src="https://lh4.googleusercontent.com/4IJDMUoFg1bqwi5guPG9NNGbnCOl3rHhCBXklSD8-lyzZlwfQClrXINLjC1KMmKTnfs1-dq5WXmxVyohMcfIVCVFh1mM-szcjrRabUXDuB4yXXqty4Z4kkh_FyQJoPyKJwtA0044y5RyMy_OvZ_6G2Y" width="543" height="270"></p>
<p><img src="https://lh4.googleusercontent.com/c9kVvXup3z9gQSV1yfxO3bNyjlkcawt6MkHX7KnesY7BrSMrsn0cMcybMCGM8ctxSkpe4v42W6lYg1OmG8gUeqqfWELsj3Wt09ggHW7hknPkvMkT_j6ihMzwcmm3AKxJy_1j1b3cB5YMksPlN3CGT1g" width="585" height="144"></p>
<p><br></p>
<p>Ejecuci&oacute;n en una aplicaci&oacute;n android</p>
<p><br></p>
<p>Clases</p>
<p>Api</p>
<p><img src="https://lh4.googleusercontent.com/u6Nazof_3c6z825MRNiER5H7bM6G27wHVQ5koI799kSDFKdgeotmYIPmdyjFx68vUdOmtUVkbNOvpdyPOoZUOilFKk3nhLt2kef9649GX9zbpYCmZyvGAU7oJy785LJLOyB_iMrMwG1JbOTNQY9B5IM" width="505" height="194"></p>
<p><br></p>
<p>Producto</p>
<p><img src="https://lh5.googleusercontent.com/imVGYly4G1fWuHD_dL9GpzP-YQC5t4rv_fWCrf8kU5gTT_PirsmeCT08ZaDZRcPYYeJtE-OE9PCxus9_vc40aNt4W7A117TnEAUnzLx2bY8MhSukhHl5_VCBSR-3b2U_kZWjosJBCmmNECBZEkf8-wE" width="508" height="187"></p>
<p><br></p>
<p>ProductoAdapter</p>
<p>Adaptamos nuestra lista devuelta.</p>
<p><img src="https://lh4.googleusercontent.com/oXNXgZ8cDxXKYvXHq496C3doAXko0hK6PtUx3BCqRLbhUOilgeNrJgePQJxUybLjBk3E3Z7b--KqahaTI6n9iolMeUdLu4fC8hR9hkZmWkdQaNJaE2gfbDER5dYtl-xcset2u5XaFIG0NGfwCVTiDvo" width="602" height="299"></p>
<p><br></p>
<p>MainActivity</p>
<p><img src="https://lh6.googleusercontent.com/ABnTJ1bruLdLd5anrcRf9EF7EtEObl92WxDxu4UbVJUftdionpvaQlLmPemcueGQGo_BQXvCv6KSuit1XiemN3BiDHlLroRN956GHKnx0CdkKLx1n2RhhiaImwVciOnuGeGo3p3sUen34f9V_4HbOdU" width="602" height="475"></p>
<p><br></p>
<p>Layout</p>
<p>activity_main.xml</p>
<p><img src="https://lh6.googleusercontent.com/6tC77e6z3aDb313vmx1Kf45NPVT9juY__xPbbG_A5kUGyrHA6LwtKPQ4l2M0xbr5zx0AyRP2RQaQ4OvXTIPdhWt10V5hsIkfPmh46ttF5eYQ64W2kxda6hMBqb92sjuof6z_xtL_WHOYOzQ0l4vv7dI" width="602" height="456"></p>
<p><br></p>
<p>item_producto.xml</p>
<p><img src="https://lh3.googleusercontent.com/aYXeW_WQlR_RcENE5tXzga3LkVhx2fNEcnE6iwSYiUB410WzgSP7DFougqzmrYhuCMu_HneN6QMIaM91yjMrk4ANVUktQ6f1XhfCq3RbnYZmC45IqS-Wg0htB-eAhiWZnBHcZnvRi3-8lbK6quFTj_Q" width="602" height="455"></p>
<p><br></p>
<p>Resultado:</p>
<p><img src="https://lh6.googleusercontent.com/BllnTUiTWAq2ynBBMTD3tGSCoW1BTh23HzgA4cOIIdYoRA9aUOOOyX_2LQo_l0i-MrdIDI_hrvulsn8r12_d5pX7oc2S8ieLcCTshMoAjTuQECKEqdJHWurtHnx5mWQsspo7-a7YvFh_nVV6Vr2c0DE" width="441" height="897"></p>
