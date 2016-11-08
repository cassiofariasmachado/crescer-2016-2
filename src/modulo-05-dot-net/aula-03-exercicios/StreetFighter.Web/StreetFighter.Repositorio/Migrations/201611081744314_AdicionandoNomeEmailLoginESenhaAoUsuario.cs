namespace StreetFighter.Repositorio.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class AdicionandoNomeEmailLoginESenhaAoUsuario : DbMigration
    {
        public override void Up()
        {
            AddColumn("dbo.Usuario", "Nome", c => c.String());
            AddColumn("dbo.Usuario", "Email", c => c.String());
            AddColumn("dbo.Usuario", "Login", c => c.String());
            AddColumn("dbo.Usuario", "Senha", c => c.String());
        }
        
        public override void Down()
        {
            DropColumn("dbo.Usuario", "Senha");
            DropColumn("dbo.Usuario", "Login");
            DropColumn("dbo.Usuario", "Email");
            DropColumn("dbo.Usuario", "Nome");
        }
    }
}
